package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "intakeItem")
public class IntakeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ItemlineNo")
    private int id;

    @Column(name = "ItemCode")
    @NotEmpty(message = "*Please provide Item Code")
    private int itemid;

    @Column(name = "Quantity")
    @NotEmpty(message = "*Please provide Quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "InvoiceNum", nullable = false)
    private Invoice invoice;


}