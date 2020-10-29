package com.rajamarul.dao;

import com.rajamarul.mapper.StudentRowMapper;
import com.rajamarul.model.Student;
import com.rajamarul.resultSetExtractor.StudentResultSetExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Student student) {

        String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
        Object[] args = {student.getRollNo(),student.getName(),student.getAddress()};
        int noOfRowInserted = jdbcTemplate.update(sql,args);
        System.out.println("No of row inserted is: "+noOfRowInserted);

    }


    @Override
    public boolean deleteRecordByRollNo(int rollNo) {
        String sql = "DELETE FROM STUDENT WHERE ROLLNO =?";
        int noOfRowDeleted = jdbcTemplate.update(sql,rollNo);
        System.out.println("No of row deleted : "+noOfRowDeleted);
        return noOfRowDeleted == 1;
    }

    @Override
    public int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress) {
        String sql = "DELETE FROM STUDENT WHERE NAME =? OR ADDRESS = ?";
        Object[] args = {studentName,studentAddress};
        int noOfRowDeleted = jdbcTemplate.update(sql,args);
        System.out.println("No of students are deleted :" + noOfRowDeleted);
        return noOfRowDeleted;
    }

    @Override
    public void cleanUp() {
        String sql = "Truncate table student";
        jdbcTemplate.update(sql);
        System.out.println("Student Table is Truncated");
    }

    @Override
    public void insert(List<Student> students) {

        String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        for(Student tempStudent :students) {
            Object[] studentData= {tempStudent.getRollNo(),tempStudent.getName(),tempStudent.getAddress()};
            batchArgs.add(studentData);
        }
        jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println("Batch Update completed");
    }

    @Override
    public List<Student> findAllStudent() {
        String sql = "SELECT * FROM STUDENT";
        // Used query() method ....
        List<Student> studentList = jdbcTemplate.query(sql,new StudentRowMapper());
        // The below line code will work.
        //List<Student> studentList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
        return studentList;
    }


    @Override
    public Student findStudentByRollNo(int rollNo) {

        String sql = "select * from Student where rollNo = ?";
        Object[] args ={rollNo};
        Student student = jdbcTemplate.queryForObject(sql,args,new StudentRowMapper());

        return student;
    }

    @Override
    public Student findStudentByRollNoWithBeanPropertyRowMapper(int rollNo) {
        //If bean property and db coloum dont match ...then query should be like this.
       // String sql = "select ROLL_NO as rollno,STUDENT_NAME as name ,STUDENT_ADDRES as address from Student where rollNo = ?";
        String sql = "select * from Student where rollNo = ?";
        Object[] args ={rollNo};

        Student student = jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<Student>(Student.class));

        return student;
    }

    @Override
    public List<Student> findAllStudentWithBeanPropertyRowMapper() {
        String sql = "SELECT * FROM STUDENT";
        // Used query() method ....
        //List<Student> studentList = jdbcTemplate.query(sql,new StudentRowMapper());
        // The above line code will work.
        List<Student> studentList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
        return studentList;
    }

    @Override
    public List<Student> findStudentByNameWithResultSetExtractor(String studentName) {
        String sql = "SELECT * FROM STUDENT WHERE name =? ";
        List<Student> studentList = jdbcTemplate.query(sql,new StudentResultSetExtractor(),studentName);

        return studentList;
    }


}
