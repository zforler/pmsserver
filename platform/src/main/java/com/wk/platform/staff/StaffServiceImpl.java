package com.wk.platform.staff;

import com.wk.bean.Staff;
import com.wk.bean.StaffDepart;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.department.DepartmentRepo;
import com.wk.platform.department.DepartmentService;
import com.wk.platform.repo.StaffDepartRepo;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StaffServiceImpl implements StaffService {
        @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private StaffDepartRepo staffDepartRepo;
    @Autowired
    private DepartmentRepo departmentRepo;


    @Transactional
    public void saveStaffDepart(String staffId,String departmentId,int time){
        StaffDepart staffDepart = new StaffDepart();
        staffDepart.setDepartmentId(departmentId);
        staffDepart.setStaffId(staffId);
        staffDepart.setBeginTime(time);
        staffDepartRepo.saveAndFlush(staffDepart);
    }
    @Transactional
    @Override
    public Result<Staff> addStaff(Staff staff, String operateUserId) {


        int second = TimeUtil.getCurrentInSecond();
        staff.setCreateTime(second);
        staff.setUpdateTime(second);
        String staffId = staff.getStaffId();
        if(StringUtils.isBlank(staffId)){
            staffId = seqService.getNextBusinessId(Const.BZ_STAFF, staff.getCustomerId(), 8);
        }else{
            Staff staffId1 = staffRepo.findFirstByStaffId(staffId);
            if(staffId1!=null){
                return Result.error("员工编号已存在");
            }
        }
        staff.setStaffId(staffId);
        Staff staff1 = staffRepo.saveAndFlush(staff);
        String departmentId = staff.getDepartmentId();
        if(StringUtils.isNotBlank(departmentId)){
            saveStaffDepart(staffId,departmentId,second);
        }

        return Result.success(staff1);
    }
    @Transactional
    @Override
    public Result updateStaff(Staff staff, String operateUserId) {
        String staffId = staff.getStaffId();
        String sql = "SELECT s.*,sd.department_id FROM staff s LEFT JOIN staff_depart sd ON s.staff_id=sd.staff_id" +
                " AND sd.end_time=0 WHERE s.staff_id=:staffId";
        Map<String,Object> param = new HashMap<>();
        param.put("staffId",staffId);
        Staff oldStaff = commonService.nativeQuery4FirstObject(sql,param,Staff.class);

        if(oldStaff == null){
            return Result.error("没有此员工");
        }
        int second = TimeUtil.getCurrentInSecond();
        staff.setCreateTime(oldStaff.getCreateTime());
        staff.setUpdateTime(second);
        if(staff.getLeaveTime() > 0){
            if(staff.getLeaveTime() < staff.getEntryTime()){
                return Result.error("离职时间不能再入职时间之前");
            }
            staff.setStatus(Const.STAFF_STATUS_LEAVE);
        }
        staffRepo.saveAndFlush(staff);
        //修改部门
        String oldPartId = oldStaff.getDepartmentId();
        String newPartId = staff.getDepartmentId();
        if(StringUtils.isNotBlank(oldPartId) && !oldPartId.equals(newPartId)){
            staffDepartRepo.updateEndTime(staffId,oldPartId,second);
        }
        if(StringUtils.isNotBlank(newPartId)){
            saveStaffDepart(staffId,newPartId,second);
        }
        return Result.success();
    }

    @Transactional
    @Override
    public Result deleteStaff(String staffId, String operateUserId) {
        staffRepo.updatStaffStatus(staffId,Const.DATA_STATUS_DEL);
        return Result.success();
    }

    @Override
    public Result<List<Staff>> getStaffList(String keyword, String customerId, String operateUserId) {
        return null;
    }

    @Override
    public Result<PageList<Staff>> getStaffPageList(String keyword, int page, int size, String customerId,
                                                    int status,int sex,int staffType,String departmentId,int departmentType,
                                                    String operateUserId) {
        String sql = "SELECT sf.*,d.department_id,d.name departmentName,d.parents FROM staff sf LEFT JOIN staff_depart sd" +
                " ON sf.staff_id=sd.staff_id AND sd.end_time=0 LEFT JOIN department d ON" +
                " sd.department_id=d.department_id WHERE sf.customer_id=:customerId AND sf.status!=99 ";

        Map<String,Object> param = new HashMap<>();
        param.put("customerId", customerId);

        if(sex >= 0){
            sql += " AND sex=:sex";
            param.put("sex", sex);
        }
        if(status >= 0){
            sql += " AND sf.status=:status";
            param.put("status", status);
        }
        if(staffType >= 0){
            sql += " AND staff_type=:staffType";
            param.put("staffType", staffType);
        }
//        if(departmentType>-1){
//            if(departmentType == Const.DEPART_TYPE_GROUP){
//                sql += " AND d.department_id=:departmentId";
//                param.put("departmentId", departmentId);
//            }else{
//                sql += " AND FIND_IN_SET(:departmentId,d.parents)";
//                param.put("departmentId", departmentId);
//            }
//        }
        if(StringUtils.isNotBlank(departmentId)){
            sql += " AND d.department_id=:departmentId";
            param.put("departmentId", departmentId);
        }
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (sf.staff_id LIKE :keyword OR sf.staff_name like :keyword OR phone like :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "staffId");
        Page<Staff> list = commonService.pageBySql(sql,param,pageable,Staff.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }

    @Override
    public Result<List<Staff>> getNoDepartStaffList(String keyword, int sex, int staffType, String customerId,
                                                    String operateUserId) {
        String sql = "SELECT s.* FROM staff s LEFT JOIN staff_depart sd ON s.staff_id=sd.staff_id WHERE s.customer_id=:customerId" +
                " AND status!=99 AND sd.end_time IS NULL";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId", customerId);

        if(sex >= 0){
            sql += " AND sex=:sex";
            param.put("sex", sex);
        }

        if(staffType >= 0){
            sql += " AND staff_type=:staffType";
            param.put("staffType", staffType);
        }

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (sf.staff_id LIKE :keyword OR sf.staff_name like :keyword)";
            param.put("keyword","%"+keyword+"%");
        }
        List<Staff> staffList = commonService.listBySql(sql, param, Staff.class);
        return Result.success(staffList);
    }

    @Override
    public Result configDeparts(String staffIds, String departmentId, String operateUserId) {
        if(StringUtils.isBlank(staffIds)){
            return Result.error("请选择员工");
        }
        String[] idArr = staffIds.split(",");
        List<StaffDepart> list = new ArrayList<>();
        int second = TimeUtil.getCurrentInSecond();
        for (int i = 0,len = idArr.length; i < len; i++) {
            StaffDepart staffDepart = new StaffDepart();
            staffDepart.setStaffId(idArr[i]);
            staffDepart.setDepartmentId(departmentId);
            staffDepart.setBeginTime(second);
            list.add(staffDepart);
        }
        staffDepartRepo.saveAll(list);

        departmentRepo.updateStaffCount(departmentId,idArr.length);

        return Result.success();
    }

    @Transactional
    @Override
    public Result unbindDepart(int id, String operateUserId) {
        StaffDepart staffDepart = staffDepartRepo.findById(id).orElse(null);
        if(staffDepart == null){
            return Result.error("无此数据");
        }
        staffDepartRepo.updateEndTimeById(id, TimeUtil.getCurrentInSecond());
        departmentRepo.updateStaffCount(staffDepart.getDepartmentId(),-1);

        return Result.success();
    }

    @Override
    public Result<PageList<Staff>> getDepartStaffPageList(String keyword, int page, int size, String customerId, int sex,
                                                          int staffType, String departmentId, String operateUserId) {
        String sql = "SELECT sf.*,d.department_id FROM staff sf LEFT JOIN staff_depart sd" +
                " ON sf.staff_id=sd.staff_id AND sd.end_time=0 LEFT JOIN department d ON" +
                " sd.department_id=d.department_id WHERE sf.customer_id=:customerId AND sf.status!=99 AND d.department_id=:departmentId ";

        Map<String,Object> param = new HashMap<>();
        param.put("customerId", customerId);
        param.put("departmentId", departmentId);

        if(sex >= 0){
            sql += " AND sex=:sex";
            param.put("sex", sex);
        }
        if(staffType >= 0){
            sql += " AND staff_type=:staffType";
            param.put("staffType", staffType);
        }

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (sf.staff_id LIKE :keyword OR sf.staff_name like :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "staffId");
        Page<Staff> list = commonService.pageBySql(sql,param,pageable,Staff.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }
}
