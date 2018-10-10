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
@Table(name = "saleItem")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SaleItemNo")
    private int id;

    @Column(name = "ItemCode")
    @NotEmpty(message = "*Please provide Item Code")
    private int itemid;

    @Column(name = "Quantity")
    @NotEmpty(message = "*Please provide Quantity")
    private int quantity;

    @Column(name = "Discount")
    @Builder.Default
    private int discount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "VoucherNum", nullable = false)
    private Voucher voucher;

}