package com.radha.gopal.repository;

import com.radha.gopal.model.Brand;
import com.radha.gopal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface BrandRepository extends JpaRepository<Brand, Integer> {
//    Brand findByBrand(String Brand);

}
