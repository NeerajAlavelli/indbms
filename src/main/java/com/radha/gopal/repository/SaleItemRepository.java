package com.radha.gopal.repository;

import com.radha.gopal.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("saleItemRepository")
public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {

}
