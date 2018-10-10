package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Set;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voucher")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Voucher_id")
    private int id;

    @Column(name = "Amount")
    @Range(min = 0l, message = "*Please provide Amount")
    private int amount;

    @Column(name = "SaleDate")
    @Past(message = "*Please provide Date of Sale")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date saledate;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "Cust_id", nullable = true)
    private Customer customer;


}