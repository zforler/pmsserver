package com.wk.platform.shift;

import com.wk.bean.Shift;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShiftServiceImpl implements ShiftService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;
    @Autowired
    private ShiftRepo shiftRepo;
    public long getSecond(int time, int delayTime){
        long t = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT).toEpochSecond(OffsetDateTime.now().getOffset());
        return t+time+delayTime*60;
    }
    public void checkTime(String customerId,int beginTime,int endTime,int delayTime,int id) throws Exception {
        List<Shift> shifts = null;
        if(id < 0){
            shifts = shiftRepo.findAllByCustomerIdAndReactiveTimeOrderByBeginTimeAsc(customerId, 0);
        }else{
            shifts = shiftRepo.findAllByCustomerIdAndReactiveTimeAndIdNotOrderByBeginTimeAsc(customerId,0,id);
        }
        if(shifts == null || shifts.size() == 0){
            return;
        }
        Shift shift = null;
        int minBeginTime = beginTime;
        int delay = delayTime*60;
        for (int i = 0, size = shifts.size(); i < size; i++) {
            shift = shifts.get(i);
            int oldBeginTime = shift.getBeginTime();
            int oldEndTime =shift.getEndTime();
            if((beginTime>= oldBeginTime && beginTime < oldEndTime)
                    || (endTime > oldBeginTime && endTime <= oldEndTime)
            ||(oldBeginTime>= beginTime && oldBeginTime < endTime)
                    || (oldBeginTime > endTime && oldEndTime <= endTime)
            ||oldBeginTime<delay){
                throw new Exception("所选时间段已存在班次");
            }
            if(oldBeginTime<minBeginTime){
                minBeginTime = oldBeginTime;
            }
        }
        if(shifts.get(shifts.size()-1).getDelayTime() * 60 > minBeginTime){
            throw new Exception("所选时间段已存在班次");
        }
    }
    @Transactional
    @Override
    public Result<Shift> addShift(Shift shift, String operateUserId) {
        String customerId = shift.getCustomerId();
        Shift old = shiftRepo.findFirstByCustomerIdAndShiftName(customerId, shift.getShiftName());
        if(old != null){
            return Result.error("班次名称重复");
        }
        try {
            checkTime(customerId,shift.getBeginTime(),shift.getEndTime(),shift.getDelayTime(),-1);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
        String shiftId = seqService.getNextBusinessId(Const.BZ_SHIFT, customerId, 2);
        shift.setShiftId(shiftId);
        int second = TimeUtil.getCurrentInSecond();
        shift.setCreateTime(second);
        shift.setActiveTime(second);
        shift.setReactiveTime(0);
        Shift newShift = shiftRepo.saveAndFlush(shift);
        return Result.success(newShift);
    }
    @Transactional
    @Override
    public Result updateShift(Shift shift, String operateUserId) {
        int id = shift.getId();

        Shift old = shiftRepo.findFirstById(id);
        if(old == null){
            return Result.error("没有此班次");
        }
        try {
            checkTime(shift.getCustomerId(),shift.getBeginTime(),shift.getEndTime(),+shift.getDelayTime(),id);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
        String newName = shift.getShiftName();
        String oldName = old.getShiftName();
        String shiftId = shift.getShiftId();
        String customerId = shift.getCustomerId();
        if(!oldName.equals(newName)){
            Shift temp = shiftRepo.findFirstByCustomerIdAndShiftNameAndShiftIdNot(customerId, newName, shiftId);
            if(temp != null){
                return Result.error("班次名称重复");
            }
        }
        Integer newBeginTime = shift.getBeginTime();
        Integer newEndTIme = shift.getEndTime();
        if(old.getBeginTime()==newBeginTime && old.getEndTime() == newEndTIme){
            return Result.success();
        }
        int second = TimeUtil.getCurrentInSecond();
        old.setReactiveTime(second);
        shiftRepo.saveAndFlush(old);
        shift.setActiveTime(second);
        shift.setReactiveTime(0);
        shift.setId(0);
        shift.setShiftId(old.getShiftId());
        shift.setCreateTime(old.getCreateTime());
        shiftRepo.saveAndFlush(shift);
        return Result.success();
    }

    @Override
    public Result deleteShift(String shiftId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Shift>> getShiftList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT * FROM shift WHERE reactive_time=0 AND customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (shift_id LIKE :keyword OR shift_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }
        sql += " order by begin_time asc";
        List<Shift> shifts = commonService.listBySql(sql, param, Shift.class);

        return Result.success(shifts);
    }

    @Override
    public Result<List<Shift>> getHisShiftList(String shiftId, String customerId, String operateUserId) {
        List<Shift> shifts = shiftRepo.findAllByShiftId(shiftId);
        return Result.success(shifts);
    }
}
