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
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Expense_id")
    private int id;

    @Column(name = "ExpenseType")
    @NotEmpty(message = "*Please provide Type")
    private String type;

    @Column(name = "Amount")
    @Range(min = 0l, message = "*Please provide valid Amount")
    private int amount;

    @Column(name = "Date")
    @Past(message = "*Please provide valid Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateofexpenditure;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "StoreNum", nullable = true)
    private Store storeid;

}