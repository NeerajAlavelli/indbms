package com.radha.gopal.repository;

import com.radha.gopal.model.Wage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("wageRepository")
public interface WageRepository extends JpaRepository<Wage, Integer> {
//    Wage findByWage(String Wage);

}
