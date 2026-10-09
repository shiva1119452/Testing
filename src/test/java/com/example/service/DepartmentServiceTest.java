package com.example.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.Department;
import com.example.repository.DepartmentMapper;

class DepartmentServiceTest {

    private DepartmentMapper departmentMapper;
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        departmentMapper = mock(DepartmentMapper.class);
        departmentService = new DepartmentService(departmentMapper);
    }

    @Test
    void getAllDepartmentsReturnsMapperResults() {
        List<Department> expected = List.of(new Department());
        when(departmentMapper.findAllDepartments()).thenReturn(expected);

        List<Department> result = departmentService.getAllDepartments();

        assertSame(expected, result);
        verify(departmentMapper).findAllDepartments();
    }
}
