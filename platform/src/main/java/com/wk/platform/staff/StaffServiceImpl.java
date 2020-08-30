package com.wk.platform.staff;

import com.wk.bean.*;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.card.CardService;
import com.wk.platform.department.DepartmentRepo;
import com.wk.platform.repo.StaffCardRepo;
import com.wk.platform.repo.StaffDepartRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
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
    @Autowired
    private CardService cardService;
    @Autowired
    private StaffCardRepo staffCardRepo;

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
        Staff staffTemp = staffRepo.findFirstByStaffNoAndCustomerId(staff.getStaffNo(), staff.getCustomerId());
        if(staffTemp != null){
            return Result.error("员工编号已存在");
        }
        int second = TimeUtil.getCurrentInSecond();
        staff.setCreateTime(second);
        staff.setUpdateTime(second);

        String staffId = seqService.getNextBusinessId(Const.BZ_STAFF, staff.getCustomerId(), 8);

        staff.setStaffId(staffId);
        Staff staff1 = staffRepo.saveAndFlush(staff);
        String departmentId = staff.getDepartmentId();
        if(StringUtils.isNotBlank(departmentId)){
            saveStaffDepart(staffId,departmentId,second);
            departmentRepo.updateStaffCount(departmentId,1);
        }
//        if(StringUtils.isNotBlank(staff.getCardId())){
//            cardService.saveStaffCard(staff.getCardId(),staffId,second);
//        }
        return Result.success(staff1);
    }
    @Transactional
    @Override
    public Result updateStaff(Staff staff, String operateUserId) {
        String staffId = staff.getStaffId();
        Staff staffTemp = staffRepo.findFirstByStaffNoAndCustomerIdAndStaffIdNot(staff.getStaffNo(), staff.getCustomerId(),staffId);
        if(staffTemp != null){
            return Result.error("员工编号已存在");
        }
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
            departmentRepo.updateStaffCount(oldPartId,-1);
        }
        if(StringUtils.isNotBlank(newPartId)){
            saveStaffDepart(staffId,newPartId,second);
            departmentRepo.updateStaffCount(newPartId,1);
        }
//        //修改卡
//        String oldCardId = staff.getCardId();
//        String newCardId = staff.getCardId();
//        if(StringUtils.isNotBlank(oldCardId) && !oldCardId.equals(newCardId)){
//            staffCardRepo.updateEndtimeByCardId(oldCardId,second);
//        }
//        if(StringUtils.isNotBlank(newCardId)){
//            cardService.saveStaffCard(newCardId,staffId,second);
//        }
        return Result.success();
    }

    @Transactional
    @Override
    public Result deleteStaff(String staffId, String operateUserId) {
        staffRepo.updatStaffStatus(staffId,Const.DATA_STATUS_DEL);
        unbindDepart(staffId,operateUserId);
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
                " ON sf.staff_id=sd.staff_id AND sd.end_time=0 LEFT JOIN department d ON sd.department_id=d.department_id" +
//                " LEFT JOIN staff_card sc ON sf.staff_id=sc.staff_id  AND sc.end_time=0 " +
                " WHERE sf.customer_id=:customerId AND sf.status!=99 ";

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
            sql += " AND (sf.staff_no LIKE :keyword OR sf.staff_name like :keyword OR phone like :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "staffId");
        Page<Staff> list = commonService.pageBySql(sql,param,pageable,Staff.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }

    @Override
    public Result<List<Staff>> getNoDepartStaffList(String keyword, int sex, int staffType, String customerId,
                                                    String operateUserId) {
        String sql = "SELECT * FROM staff WHERE customer_id=:customerId AND staff_id NOT IN(SELECT staff_id FROM" +
                " staff_depart WHERE customer_id=:customerId AND end_time=0) AND status!=99";
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
            sql += " AND (s.staff_no LIKE :keyword OR s.staff_name like :keyword)";
            param.put("keyword","%"+keyword+"%");
        }
        List<Staff> staffList = commonService.listBySql(sql, param, Staff.class);
        return Result.success(staffList);
    }
    @Transactional
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
    public Result unbindDepart(String staffId, String operateUserId) {
        StaffDepart staffDepart = staffDepartRepo.findFirstByStaffIdAndEndTimeEquals(staffId,0);
        if(staffDepart == null){
            return Result.error("无此数据");
        }
        staffDepartRepo.updateEndTimeById(staffDepart.getId(), TimeUtil.getCurrentInSecond());
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
            sql += " AND (sf.staff_no LIKE :keyword OR sf.staff_name like :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "staffId");
        Page<Staff> list = commonService.pageBySql(sql,param,pageable,Staff.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }

    @Override
    public Result<List<Staff>> getUnbindCardStaffList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT * FROM staff WHERE customer_id=:customerId AND status!=99 AND staff_id NOT IN" +
                "(SELECT staff_id FROM staff_card WHERE card_id LIKE :card AND end_time=0)";

        Map<String,Object> param = new HashMap<>();
        param.put("customerId", customerId);
        param.put("card", customerId+"%");
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (staff_no LIKE :keyword OR staff_name like :keyword)";
            param.put("keyword","%"+keyword+"%");
        }
        List<Staff> staffList = commonService.listBySql(sql, param, Staff.class);

        return Result.success(staffList);
    }


    @Transactional
    @Override
    public Result bindCards(String cardIds, String staffId, String customerId, String operateUserId) {
        int second = TimeUtil.getCurrentInSecond();
        if(StringUtils.isBlank(cardIds)){
            return Result.error("请选择IC卡");
        }
        String[] arr = cardIds.split(",");
        for (int i = 0,len = arr.length; i < len; i++) {
            StaffCard staffCard = new StaffCard();
            staffCard.setEndTime(0);
            staffCard.setBeginTime(second);
            staffCard.setCardId(arr[i]);
            staffCard.setStaffId(staffId);
            staffCardRepo.saveAndFlush(staffCard);
        }
        return Result.success();
    }
    @Transactional
    @Override
    public Result unbindCards(String cardIds, String staffId, String customerId, String operateUserId) {
        if(StringUtils.isBlank(cardIds)){
            return Result.error("请选择IC卡");
        }
        String[] arr = cardIds.split(",");
        staffCardRepo.updateEndtimeByCardId(staffId,arr, TimeUtil.getCurrentInSecond());
        return Result.success();
    }
}
