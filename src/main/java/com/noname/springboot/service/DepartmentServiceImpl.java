package com.noname.springboot.service;

import com.noname.springboot.Exceptions.DepartmentIdNotFoundException;
import com.noname.springboot.Exceptions.DepartmentNameNotFoundException;
import com.noname.springboot.entity.Department;
import com.noname.springboot.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDeptById(Long id) throws DepartmentIdNotFoundException {

        Optional<Department> department =  departmentRepo.findById(id);
        if(department.isEmpty()){
            throw new DepartmentIdNotFoundException("Id Not found!");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department d) {

        Department department = departmentRepo.findById(id).get();

        department.setDepartmentCode(d.getDepartmentCode());
        department.setDepartmentName(d.getDepartmentName());
        department.setDepartmentAddress(d.getDepartmentAddress());

        return departmentRepo.save(department);

    }

    @Override
    public Department getDeptByName(String dptName) throws DepartmentNameNotFoundException {
        Department department = departmentRepo.findByDepartmentName(dptName);

        if(department == null){
            throw new DepartmentNameNotFoundException("The department name doesn't exist!");
        }

        return department;
    }

    @Override
    public List<Department> getDeptsByCity(String city) {
        return departmentRepo.findByAddress(city);
    }

    @Override
    public List<Department> saveDepartments(List<Department> departments) {

        return departmentRepo.saveAll(departments);
    }
}
