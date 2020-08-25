package com.wk.platform.department;

import com.wk.bean.Department;
import com.wk.common.vo.Result;

import javax.annotation.Resource;
import java.util.List;

public interface DepartmentService {
    Result<Department> addDepartment(Department department, String operateUserId);

    Result updateDepartment(Department department, String operateUserId);

    Result deleteDepartment(int id, String operateUserId);

    Result<List<Department>> getDepartmentList(String customerId,String operateUserId);
}
