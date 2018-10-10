package com.radha.gopal.repository;

import com.radha.gopal.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("supplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
//    Supplier findByPhonenoAndGstin(String Supplier,String asd);

}
