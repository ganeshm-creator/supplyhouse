package com.gm.supplyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gm.supplyhouse.dto.OrderDto;
import com.gm.supplyhouse.repository.OrderRepository;
import com.gm.supplyhouse.service.OrderService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto) {
		OrderDto savedOrderDto = orderService.createOrder(orderDto);
		return new ResponseEntity<OrderDto>(savedOrderDto, HttpStatus.CREATED);
	}
	@GetMapping("/get-all-orders")
	public ResponseEntity<List<OrderDto>> getAllOrders(@RequestParam int accountId) {
		List<OrderDto> orderList = orderService.fetchAllOrders(accountId);
		return new ResponseEntity<List<OrderDto>>(orderService.fetchAllOrders(accountId), HttpStatus.CREATED);
	}
}
