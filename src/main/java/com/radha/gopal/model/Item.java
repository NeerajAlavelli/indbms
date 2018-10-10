package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ItemID")
    private int id;

    @Column(name = "ItemName")
    @NotEmpty(message = "*Please provide Name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BrandNum", nullable = false)
    private Brand brand;

    @Column(name = "BarCode")
    @NotEmpty(message = "*Please provide BarCode")
    private String barcode;

    @Column(name = "Size")
    @NotEmpty(message = "*Please provide Size")
    private char size;

    @Column(name = "Color")
    private String color;

    @Column(name = "Discount")
    @Range(min = 0l, message = "Please provide valid discount")
    private int discount;

    @Column(name = "MRP")
    @Range(min = 0l, message = "*Please provide MRP")
    private int mrp;

    @Column(name = "CostPrice")
    @Range(min = 0l, message = "*Please provide CP")
    private int cp;


}