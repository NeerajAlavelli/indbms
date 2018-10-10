package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Invoice_id")
    private int id;

    @Column(name = "Amount")
    @NotEmpty(message = "*Please provide Amount")
    private int amount;

    @Column(name = "DeliveryDate")
    @NotEmpty(message = "*Please provide Date of Delivery")
    private Date deliverydate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SupplierNo", nullable = false)
    private Supplier supplier;


}