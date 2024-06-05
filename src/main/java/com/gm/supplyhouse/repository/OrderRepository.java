package com.gm.supplyhouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.supplyhouse.data.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>  {

	List<Order> findByAccountId(int accountId);
	public long countByAccountId(int accountId); 
}
