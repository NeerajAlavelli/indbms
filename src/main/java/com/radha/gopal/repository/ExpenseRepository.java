package com.radha.gopal.repository;

import com.radha.gopal.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("expenseRepository")
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
