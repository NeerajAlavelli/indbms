package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_id")
    private int id;

    @Column(name = "EmployeeType")
    @NotEmpty(message = "*Please provide Type")
    private String type;

    @Column(name = "EmployeeName")
    @NotEmpty(message = "*Please provide Name")
    private String empname;

    @Column(name = "AadharNo")
    @NotEmpty(message = "*Please provide AadharNo")
    private String aadhar;

    @Column(name = "Age")
    @NotEmpty(message = "*Please provide Age")
    private int age;

    @Column(name = "Address")
    @NotEmpty(message = "*Please provide Address")
    private String address;

    @Column(name = "EmpPhone")
    @NotEmpty(message = "*Please provide Phone No")
    private int phoneno;

    @Column(name = "MonthlyWage")
    @NotEmpty(message = "*Please provide Wage")
    private int wage;

    @Column(name = "JoinDate")
    @Past(message = "Please enter a valid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joindate;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "StoreNum", nullable = true)
    private Store storeid;

}