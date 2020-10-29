package com.rajamarul.resultSetExtractor;

import com.rajamarul.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentResultSetExtractor  implements ResultSetExtractor<List<Student>> {

    @Override
    public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        List<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setRollNo(resultSet.getInt("rollNo"));
            student.setName(resultSet.getString("name"));
            student.setAddress(resultSet.getString("address"));
            studentList.add(student);
        }

        System.out.println("Inside the extractData() method of ResultSetExtractor");
        return studentList;
    }
}
