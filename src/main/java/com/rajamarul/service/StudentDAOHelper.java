package com.rajamarul.service;

import com.rajamarul.dao.StudentDAOImpl;
import com.rajamarul.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDAOHelper {
    @Autowired
    private StudentDAOImpl studentDAO;

    public void setupStudentTable() {
        Student student1 = new Student();
        student1.setRollNo(1);
        student1.setName("Saravanakumar");
        student1.setAddress("usa");

        Student student2 = new Student();
        student2.setRollNo(2);
        student2.setName("SenthilKumar");
        student2.setAddress("Oriyur");

        Student student3 = new Student();
        student3.setRollNo(3);
        student3.setName("Vijakumar");
        student3.setAddress("Blr");

        Student student4 = new Student();
        student4.setRollNo(4);
        student4.setName("Rohan");
        student4.setAddress("Chicago");

        Student student5 = new Student();
        student5.setRollNo(5);
        student5.setName("Rahni");
        student5.setAddress("Michigan");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        studentDAO.insert(studentList);

    }

    public void printStudents(List<Student> studentList){

        for(Student tempStudent:studentList) {
            System.out.println(tempStudent);
        }

    }
}
