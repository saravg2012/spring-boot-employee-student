package com.rajamarul.dao;

import com.rajamarul.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public Employee getEmployee(int employeeId) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_employeeId",employeeId);
       Map<String,Object> out = simpleJdbcCall.execute(in);

       Employee employee = new Employee();
        employee.setEmployeeID(employeeId);
        employee.setName((String)out.get("out_name"));
        employee.setAge((Integer) out.get("out_age"));
        employee.setSalary((Integer) out.get("out_salary"));

        return employee;
    }
}
