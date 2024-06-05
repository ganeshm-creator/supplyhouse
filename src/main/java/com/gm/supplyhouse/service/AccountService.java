package com.gm.supplyhouse.service;

import java.util.List;

import com.gm.supplyhouse.dto.AccountDto;

public interface  AccountService {
 public AccountDto saveAccount(AccountDto accountDto);
 public AccountDto getAccount(int accountId);
 public List<AccountDto> getAllAccounts();
 
 public String  upgradeAccount(int accountId);
public String sendInviteToJoin(int accountId);
 }
