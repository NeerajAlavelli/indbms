package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wage")
public class Wage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Wage_id")
    private int id;

    @Column(name = "Amount")
    @NotEmpty(message = "*Please provide Amount")
    private int amount;

    @Column(name = "Date")
    @NotEmpty(message = "*Please provide Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateofwithdrawal;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EmpNum", nullable = false)
    private Employee employee;

}