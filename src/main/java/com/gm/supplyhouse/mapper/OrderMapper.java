package com.gm.supplyhouse.mapper;

import com.gm.supplyhouse.data.Order;
import com.gm.supplyhouse.dto.OrderDto;

public class OrderMapper {
	public static OrderDto mapToOrderDto(Order order) {
		OrderDto orderDto = new OrderDto(order.getOrderId(), order.getAccountId(), order.getOrderDate());
		return orderDto;
	}

	public static Order mapToOrder(OrderDto orderDto) {

		Order order = new Order(orderDto.getOrderId(), orderDto.getAccountId(), orderDto.getOrderDate());
		return order;
	}
}
