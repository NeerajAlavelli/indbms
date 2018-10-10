package com.radha.gopal.repository;

import com.radha.gopal.model.Invoice;
import com.radha.gopal.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
