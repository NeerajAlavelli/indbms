package com.radha.gopal.repository;

import com.radha.gopal.model.TaxReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("returnRepoitory")
public interface ReturnRepository extends JpaRepository<TaxReturn, Integer> {

}
