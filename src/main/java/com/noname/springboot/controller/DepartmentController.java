package com.noname.springboot.controller;


import com.noname.springboot.Exceptions.DepartmentIdNotFoundException;
import com.noname.springboot.Exceptions.DepartmentNameNotFoundException;
import com.noname.springboot.entity.Department;
import com.noname.springboot.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/saveDpt")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Saving a single department!");
        return departmentService.saveDepartment(department);
    }

    @PostMapping("saveDpts")
    public List<Department> saveDepartments(@Valid @RequestBody List<Department> departments){
        logger.info("Saving multiple depaertments at once!");
        return departmentService.saveDepartments(departments);
    }

    @GetMapping("/getDpts")
    public List<Department> getDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getDept/{Id}")
    public Department getDepartmentById(@PathVariable("Id") Long Id) throws DepartmentIdNotFoundException {
        return departmentService.getDeptById(Id);
    }

    @GetMapping("/getDeptByName/{dptName}")
    public Department getDepartmentByName(@PathVariable("dptName") String dptName) throws DepartmentNameNotFoundException {
        return departmentService.getDeptByName(dptName);
    }

    @GetMapping("/getDeptByCity/{city}")
    public List<Department> getDepartmentsByCity(@PathVariable("city") String city){
        return departmentService.getDeptsByCity(city);
    }

    @DeleteMapping("/delDept/{Id}")
    public void deleteDepartmentById(@PathVariable("Id") Long Id){
        departmentService.deleteDepartmentById(Id);
    }

    @PutMapping("update/{Id}")
    public Department updateDepartmentById(@PathVariable("Id") Long Id, @RequestBody Department d){
        return departmentService.updateDepartment(Id, d);
    }


}
