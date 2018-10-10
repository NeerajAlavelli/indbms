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
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Brand_id")
    private int id;

    @Column(name = "BrandName")
    @NotEmpty(message = "*Please provide Name")
    private String brandname;

    @Column(name = "Category")
    @NotEmpty(message = "*Please provide Category")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SupplierNum", nullable = false)
    private Supplier supplier;



}