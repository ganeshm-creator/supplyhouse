package com.gm.supplyhouse.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gm.supplyhouse.data.Order;
import com.gm.supplyhouse.dto.OrderDto;
import com.gm.supplyhouse.mapper.OrderMapper;
import com.gm.supplyhouse.repository.OrderRepository;


public interface  OrderService {
	public OrderDto createOrder(OrderDto orderDto) ;
	public List<OrderDto> fetchAllOrders(int accountId);
	public long getOrderCount(int accountId);
}
