package com.wk.platform.staff;

import com.wk.bean.Staff;
import com.wk.bean.StaffDepart;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.repo.StaffDepartRepo;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String staffId = seqService.getNextBusinessId(Const.BZ_STAFF, staff.getCustomerId(), 8);
        staff.setStaffId(staffId);
        Staff staff1 = staffRepo.saveAndFlush(staff);
        String departmentId = staff.getDepartmentId();
        if(StringUtils.isNotBlank(departmentId)){
            saveStaffDepart(staffId,departmentId,second);
        }

        return Result.success(staff1);
    }

    @Override
    public Result updateStaff(Staff staff, String operateUserId) {
        String staffId = staff.getStaffId();
        Staff oldStaff = staffRepo.getStaffByStaffId(staffId);
        if(oldStaff == null){
            return Result.error("没有此员工");
        }
        int second = TimeUtil.getCurrentInSecond();
        staff.setCreateTime(oldStaff.getCreateTime());
        staff.setUpdateTime(second);
        if(staff.getLeaveTime() < staff.getEntryTime()){
            return Result.error("离职时间不能再入职时间之前");
        }
        if(staff.getLeaveTime() > 0){
            staff.setStatus(Const.STAFF_STATUS_LEAVE);
        }
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
        String sql = "SELECT sf.*,d.department_id,d.name departmentName FROM staff sf LEFT JOIN staff_depart sd" +
                " ON sf.staff_id=sd.staff_id AND sd.end_time=0 LEFT JOIN department d ON" +
                " sd.department_id=d.department_id WHERE sf.customer_id=:customerId";

        Map<String,Object> param = new HashMap<>();
        param.put("customerId", customerId);

        if(sex >= 0){
            sql += " AND sex=:sex";
            param.put("sex", sex);
        }
        if(status >= 0){
            sql += " AND status=:status";
            param.put("status", status);
        }
        if(staffType >= 0){
            sql += " AND staff_type=:staffType";
            param.put("staff_type", staffType);
        }
        if(departmentType>-1){
            if(departmentType == Const.DEPART_TYPE_GROUP){
                sql += " AND d.department_id=:departmentId";
                param.put("departmentId", departmentId);
            }else{
                sql += " AND FIND_IN_SET(:departmentId,d.parents)";
                param.put("departmentId", departmentId);
            }
        }

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (sf.staff_id LIKE :keyword OR sf.staff_name like :keyword OR phone like :keyword";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "staffId");
        Page<Staff> list = commonService.pageBySql(sql,param,pageable,Staff.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }
}
