package com.rajamarul.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public String getEmployee() {
        System.out.println("Inside Employee Service");
        return "String";
    }
}
