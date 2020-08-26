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

    Result<PageList<Staff>> getStaffPageList(String keyword, int page, int size,String customerId,int status,int sex,
                                             int staffType,String departmentId,int departmentType,String operateUserId);

    Result<List<Staff>> getNoDepartStaffList(String keyword,int sex,int staffType,String customerId, String operateUserId);

    Result configDeparts(String staffIds,String departmentId,String operateUserId);

    Result unbindDepart(int id,String operateUserId);

    Result<PageList<Staff>> getDepartStaffPageList(String keyword, int page, int size,String customerId,int sex,
                                             int staffType,String departmentId,String operateUserId);
}
