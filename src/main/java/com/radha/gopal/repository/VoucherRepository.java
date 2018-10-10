package com.radha.gopal.repository;

import com.radha.gopal.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("voucherRepository")
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

}
