package com.wk.platform.department;

import com.wk.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    Department findFirstByIdAndStatusEquals(int id,int status);

    Department findFirstByDepartmentIdAndStatusEquals(String departmentId,int status);

    @Query(value = "UPDATE department SET end_time=?3,status=?2 where FIND_IN_SET(?1,parents)",nativeQuery = true)
    List<Department> updateSubDepartStatusAndEndTime(String departmentId,int status,int time);
}
