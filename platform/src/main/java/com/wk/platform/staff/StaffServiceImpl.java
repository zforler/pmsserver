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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        String staffId = seqService.getNextBusinessId(Const.BZ_STAFF, "", 8);
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
    public Result<PageList<Staff>> getStaffPageList(String keyword, int page, int size, String customerId, String operateUserId) {
        return null;
    }
}
