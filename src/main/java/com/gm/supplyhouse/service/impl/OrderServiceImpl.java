package com.gm.supplyhouse.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gm.supplyhouse.data.Order;
import com.gm.supplyhouse.dto.OrderDto;
import com.gm.supplyhouse.mapper.OrderMapper;
import com.gm.supplyhouse.repository.OrderRepository;
import com.gm.supplyhouse.service.AccountService;
import com.gm.supplyhouse.service.OrderService;

import lombok.AllArgsConstructor;

@Service
public class OrderServiceImpl implements OrderService{
	private OrderRepository orderRepository;
	private AccountService accountService;
	public OrderDto createOrder(OrderDto orderDto) {
		Order order = OrderMapper.mapToOrder(orderDto);
		Order savedOrder = orderRepository.save(order);
		OrderDto savedOrderDto = OrderMapper.mapToOrderDto(savedOrder);
		return savedOrderDto;
	}

	
	
	public OrderServiceImpl(OrderRepository orderRepository, AccountService accountService) {
		super();
		this.orderRepository = orderRepository;
		this.accountService = accountService;
	}



	public List<OrderDto> fetchAllOrders(int accountId) {
		List<Order> orderList = orderRepository.findByAccountId(accountId);
		List<OrderDto> orderDtoList = orderList.stream().map(OrderMapper::mapToOrderDto).collect(Collectors.toList());
		return orderDtoList;
	}
	
	public long getOrderCount(int accountId)
	{
		long ordercount = orderRepository.countByAccountId(accountId);
		return ordercount;
	}
}
