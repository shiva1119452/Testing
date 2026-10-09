package com.example.repository;

import com.example.model.Department;
import com.example.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
	
	    /*@Select("SELECT id, name FROM department")
	    @Results({
	        @Result(property = "id", column = "id"),
	        @Result(property = "name", column = "name"),
	        @Result(
	            property = "employees",
	            column = "id",
	            javaType = List.class,
	            many = @Many(select = "findEmployeesByDepartmentId")
	        )
	    })
	    List<Department> findAllDepartments();


	    @Select("""
	        SELECT id, name, salary
	        FROM employee
	        WHERE department_id = #{departmentId}
	        """)
	    List<Employee> findEmployeesByDepartmentId(Long departmentId);*/
	
	List<Department> findAllDepartments();

}
