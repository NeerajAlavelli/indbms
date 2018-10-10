package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Storeid")
    private int id;

    @Column(name = "StoreName")
    @NotEmpty(message = "*Please provide Name")
    private String name;

    @Column(name = "PhoneNo")
    @NotEmpty(message = "*Please provide PhoneNo")
    private String phoneno;

    @Column(name = "GSTIN")
    @NotEmpty(message = "*Please provide GSTIN")
    private String gstin;

    @Column(name = "Proprietor")
    @NotEmpty(message = "*Please provide Proprietor")
    private String proprietor;

    @Column(name = "Address")
    @NotEmpty(message = "*Please provide Address")
    private String address;
}