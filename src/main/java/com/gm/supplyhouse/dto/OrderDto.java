package com.gm.supplyhouse.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
public class OrderDto {
	private int orderId;
	private int accountId;
	private Timestamp orderDate;

}
