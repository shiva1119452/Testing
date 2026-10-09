package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.UserDto;

public interface UserMapperAnnotation {

    @Insert("""
        INSERT INTO users (name, email, age)
        VALUES (#{name}, #{email}, #{age})
        """)
    void save(UserDto user);


    @Select("""
        SELECT id, name, email, age
        FROM users
        WHERE id = #{id}
        """)
    UserDto findById(Long id);


    @Select("""
        SELECT id, name, email, age
        FROM users
        ORDER BY id
        """)
    List<UserDto> findAll();


    @Update("""
        UPDATE users
        SET name = #{name},
            email = #{email},
            age = #{age}
        WHERE id = #{id}
        """)
    void update(UserDto user);


    @Delete("""
        DELETE FROM users
        WHERE id = #{id}
        """)
    void deleteById(Long id);
}
