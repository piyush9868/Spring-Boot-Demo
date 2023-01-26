package com.noname.springboot.repository;

import com.noname.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String dptName);


    @Query("select d from Department d where d.departmentAddress = ?1")
    public List<Department> findByAddress(String city);
}
