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
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Supplier_id")
    private int id;

    @Column(name = "SupplierName")
    @NotEmpty(message = "*Please provide a Name")
    private String suppliername;

    @Column(name = "SupplierPhone")
    @NotEmpty(message = "*Please provide Phone no.")
    private String phoneno;

    @Column(name = "Location")
    @NotEmpty(message = "*Please provide Location")
    private String location;

    @Column(name = "GSTIN")
    @NotEmpty(message = "*Please provide GSTIN")
    private String gstin;

}