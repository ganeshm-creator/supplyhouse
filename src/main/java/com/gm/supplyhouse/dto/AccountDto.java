package com.gm.supplyhouse.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
public class AccountDto {
	private int accountId;
	private Timestamp creationDate;
	private int underAccountId;
	private String accountType;
}
