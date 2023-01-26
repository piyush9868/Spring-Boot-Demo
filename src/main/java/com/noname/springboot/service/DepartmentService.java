package com.noname.springboot.service;

import com.noname.springboot.Exceptions.DepartmentIdNotFoundException;
import com.noname.springboot.Exceptions.DepartmentNameNotFoundException;
import com.noname.springboot.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department getDeptById(Long id) throws DepartmentIdNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartment(Long id, Department d);

    public Department getDeptByName(String dptName) throws DepartmentNameNotFoundException;

    public List<Department> getDeptsByCity(String city);

    public List<Department> saveDepartments(List<Department> departments);
}
