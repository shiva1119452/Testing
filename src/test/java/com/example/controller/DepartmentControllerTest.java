package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.Department;
import com.example.service.DepartmentService;

class DepartmentControllerTest {

    private DepartmentService departmentService;
    private DepartmentController departmentController;

    @BeforeEach
    void setUp() {
        departmentService = mock(DepartmentService.class);
        departmentController = new DepartmentController(departmentService);
    }

    @Test
    void getAllDepartmentsDelegatesToService() {
        List<Department> expected = List.of(new Department());
        when(departmentService.getAllDepartments()).thenReturn(expected);

        List<Department> result = departmentController.getAllDepartments();

        assertSame(expected, result);
        verify(departmentService).getAllDepartments();
    }

    @Test
    void testReturnsExpectedMessage() {
        assertEquals("Testing Docker!!!", departmentController.test());
    }
}
