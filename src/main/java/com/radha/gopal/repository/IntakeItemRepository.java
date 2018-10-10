package com.radha.gopal.repository;

import com.radha.gopal.model.IntakeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("intakeItemRepository")
public interface IntakeItemRepository extends JpaRepository<IntakeItem, Integer> {

}
