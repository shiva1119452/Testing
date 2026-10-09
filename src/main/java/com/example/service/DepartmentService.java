package com.example.service;

import com.example.model.Department;
import com.example.repository.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public List<Department> getAllDepartments() {
        return departmentMapper.findAllDepartments();
    }
}