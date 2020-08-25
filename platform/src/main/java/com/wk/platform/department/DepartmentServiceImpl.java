package com.wk.platform.department;

import com.alibaba.druid.sql.visitor.functions.Concat;
import com.wk.bean.Department;
import com.wk.bean.Menus;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private SeqService seqService;
    @Autowired
    private CommonService commonService;

    @Override
    public Result<Department> addDepartment(Department department, String operateUserId) {
        int second = TimeUtil.getCurrentInSecond();
        department.setBeginTime(second);
        if(department.getType() != Const.DEPART_TYPE_STAFF){
            String departId = seqService.getNextBusinessId(Const.BZ_DEPART, department.getCustomerId(), 4);
            department.setDepartmentId(departId);
        }
        if(StringUtils.isNotBlank(department.getParentId())){
            Department parentDepart = departmentRepo.findFirstByDepartmentIdAndStatusEquals(department.getParentId(),
                    Const.DEPART_STATUS_NORMAL);
            if(parentDepart == null){
                return Result.error("上级部门不存在");
            }
            department.setParents(parentDepart.getParentId()+","+parentDepart.getDepartmentId());
        }

        Department department1 = departmentRepo.saveAndFlush(department);

        return Result.success(department1);
    }
    @Transactional
    @Override
    public Result updateDepartment(Department department, String operateUserId) {
        int id = department.getId();
        Department old = departmentRepo.findFirstByIdAndStatusEquals(id,Const.DEPART_STATUS_NORMAL);
        if(old == null){
            return Result.error("没有此部门");
        }
        if(old.getStatus() == Const.DEPART_STATUS_HISTORY){
            return Result.error("历史部门不可修改");
        }
        int second = TimeUtil.getCurrentInSecond();
        if(!department.getName().equals(old.getName())){
            Department newDepart = new Department();
            BeanUtils.copyProperties(old,newDepart);
            newDepart.setId(0);
            newDepart.setBeginTime(second);
            newDepart.setName(department.getName());
            departmentRepo.saveAndFlush(newDepart);
            old.setEndTime(second);
            old.setStatus(Const.DEPART_STATUS_HISTORY);
            departmentRepo.saveAndFlush(old);
        }
        return Result.success();
    }


    @Transactional
    @Override
    public Result deleteDepartment(int id, String operateUserId) {
        Department old = departmentRepo.findFirstByIdAndStatusEquals(id,Const.DEPART_STATUS_NORMAL);
        int second = TimeUtil.getCurrentInSecond();
        old.setEndTime(second);
        old.setStatus(Const.DATA_STATUS_DEL);
        departmentRepo.saveAndFlush(old);
        departmentRepo.updateSubDepartStatusAndEndTime(old.getDepartmentId(),second,Const.DATA_STATUS_DEL);

        return Result.success();
    }

    @Override
    public Result<List<Department>> getDepartmentList(String customerId, String operateUserId) {
        String sql = "SELECT * FROM department WHERE type != 4 AND status=0 AND customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        List<Department> departments = commonService.listBySql(sql, param, Department.class);
        List<Department> departmentList = list2Tree(departments);
        return Result.success(departmentList);
    }

    public List<Department> list2Tree(List<Department> departmentList){
        Department department = null;
        List<Department> res = new ArrayList<>();
        Map<String,Department> map = new HashMap<>();
        Map<String,List<Department>> less = new HashMap<>();
        for (int i = 0, size = departmentList.size(); i < size; i++) {
            department = departmentList.get(i);
            String departmentId = department.getDepartmentId();
            map.put(departmentId,department);
            String parentId = department.getParentId();

            if(less.containsKey(departmentId)){
                department.addChildren(less.get(departmentId));
            }

            if(StringUtils.isBlank(parentId)){
                res.add(department);
                continue;
            }else{
                if(map.containsKey(parentId)){
                    map.get(parentId).addChildren(department);
                }else{
                    if(less.get(parentId) == null){
                        less.put(parentId, new ArrayList<>());
                    }
                    less.get(parentId).add(department);
                }
            }

        }
        return res;
    }
}
