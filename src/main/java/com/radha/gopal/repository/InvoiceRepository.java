package com.radha.gopal.repository;

import com.radha.gopal.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("invoiceRepository")
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
