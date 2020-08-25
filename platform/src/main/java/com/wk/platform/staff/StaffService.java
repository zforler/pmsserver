package com.wk.platform.staff;

import com.wk.bean.Staff;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

import java.util.List;

public interface StaffService {
    Result<Staff> addStaff(Staff staff, String operateUserId);

    Result updateStaff(Staff staff,String operateUserId);

    Result deleteStaff(String staffId,String operateUserId);

    Result<List<Staff>> getStaffList(String keyword,String customerId, String operateUserId);

    Result<PageList<Staff>> getStaffPageList(String keyword, int page, int size,String customerId, String operateUserId);
}
