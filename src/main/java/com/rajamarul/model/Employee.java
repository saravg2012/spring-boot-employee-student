package com.rajamarul.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Employee {

    private int employeeID;
    private String name;
    private int age;
    private int salary;


}
