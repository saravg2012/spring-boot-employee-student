package com.rajamarul.dao;

import com.rajamarul.model.Student;

import java.util.List;

public interface StudentDAO {

    void insert(Student student);
    boolean deleteRecordByRollNo(int rollNo);
    int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress);
    void cleanUp();
    void insert(List<Student> students);
    List<Student>findAllStudent();
    Student findStudentByRollNo(int rollNo);
    Student findStudentByRollNoWithBeanPropertyRowMapper(int rollNo);
    List<Student> findAllStudentWithBeanPropertyRowMapper();
    List<Student>findStudentByNameWithResultSetExtractor(String studentName);


}
