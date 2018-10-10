package com.radha.gopal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Set;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "taxReturn")
public class TaxReturn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Return_id")
    private int id;

    @Column(name = "ReturnType")
    @NotEmpty(message = "*Please provide Type")
    private String type;

    @Column(name = "Amount")
    @Range(min = 0l, message = " provide your price")
    private int amount;

    @Column(name = "Date")
    @Past(message = "*Please provide Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returndate;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "StoreNo", nullable = true)
    private Store store;




}