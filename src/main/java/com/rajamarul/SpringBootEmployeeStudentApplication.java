package com.rajamarul;

import com.rajamarul.dao.EmployeeDAOImpl;
import com.rajamarul.dao.StudentDAOImpl;
import com.rajamarul.model.Employee;
import com.rajamarul.model.Student;
import com.rajamarul.service.EmployeeService;
import com.rajamarul.service.StudentDAOHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

//https://www.youtube.com/watch?v=7oGPkjmF4y0
@SpringBootApplication
public class SpringBootEmployeeStudentApplication implements CommandLineRunner{

	@Autowired
	private  ApplicationContext context;

	@Autowired
	private StudentDAOHelper studentDAOHelper;

	/*@Autowired
	private StudentDAOImpl studentDAO ;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeStudentApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		StudentDAOImpl studentDAOImpl = context.getBean(StudentDAOImpl.class);

		/*Student student = new Student();
		student.setRollNo(5);
		student.setName("senthil");
		student.setAddress("oriyur");*/

		// Insert the records
				//studentDAOImpl.insert(student);
				//studentDAO.insert(student);

		// Delete the Records
				//boolean isDeleted = studentDAOImpl.deleteRecordByRollNo(1);
				//System.out.println(isDeleted);

		//Delete by Name or Address
				//studentDAOImpl.deleteRecordByStudentNameOrStudentAddress("vijay","oriyur");

		//Truncate the tables
				// studentDAOImpl.cleanUp();

		//LoadTest Data by Batch update
				//studentDAOHelper.setupStudentTable();

         //   StoredProcedure Call ....Having issues and to be fixed.
				// 	EmployeeDAOImpl employeeDAOImpl = context.getBean(EmployeeDAOImpl.class);Employee employee = employeeDAOImpl.getEmployee(101);
		       //	System.out.println(employee);

		// FindAllRecords .... With Row Mapper
				//List<Student> studentList = studentDAOImpl.findAllStudent();
				//studentDAOHelper.printStudents(studentList);

		// Get a Single Student records
		       //System.out.println(studentDAOImpl.findStudentByRollNo(1));

		//By using BeanPropertyRowMapper() - get student Records.
				// Student student = studentDAOImpl.findStudentByRollNoWithBeanPropertyRowMapper(1);
				// System.out.println(student);

		// FindAllRecords ....With BeanProperty row Mapper
			// List<Student> studentList = studentDAOImpl.findAllStudentWithBeanPropertyRowMapper();
		   //  studentDAOHelper.printStudents(studentList);

		// findAllRecords ....With ResultSetExtractor

		List<Student> studentList = studentDAOImpl
				.findStudentByNameWithResultSetExtractor("Saravanakumar");
		studentDAOHelper.printStudents(studentList);


	}
}
