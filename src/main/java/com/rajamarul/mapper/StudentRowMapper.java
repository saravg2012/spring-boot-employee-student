package com.rajamarul.mapper;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.rajamarul.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setRollNo(rs.getInt("rollNo"));
        student.setName(rs.getString("name"));
        student.setAddress(rs.getString("address"));
        System.out.println("mapRow() called ...How many times? ");
        return student;
    }
}
