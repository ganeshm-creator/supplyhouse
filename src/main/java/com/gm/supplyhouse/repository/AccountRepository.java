package com.gm.supplyhouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.supplyhouse.data.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	List<Account> findByAccountType(String accountType);
}
