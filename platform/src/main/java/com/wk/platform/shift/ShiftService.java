package com.wk.platform.shift;

import com.wk.bean.Shift;
import com.wk.common.vo.Result;

import java.util.List;

public interface ShiftService {
    Result<Shift> addShift(Shift shift, String operateUserId);

    Result updateShift(Shift shift,String operateUserId);

    Result deleteShift(String shiftId,String operateUserId);

    Result<List<Shift>> getShiftList(String keyword, String customerId, String operateUserId);
    Result<List<Shift>> getHisShiftList(String shiftId, String customerId, String operateUserId);
}
