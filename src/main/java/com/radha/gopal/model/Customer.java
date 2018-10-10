package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Customer_id")
    private int id;

    @Column(name = "CustomerName")
    @NotEmpty(message = "*Please provide a Name")
    private String name;

    @Column(name = "CustomerPhone")
    @NotEmpty(message = "*Please provide Phone no.")
    private String phoneno;

    @Column(name = "Address")
    @NotEmpty(message = "*Please provide Address")
    private String location;

}