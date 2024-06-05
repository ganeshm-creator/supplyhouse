package com.gm.supplyhouse.mapper;

import com.gm.supplyhouse.data.Account;
import com.gm.supplyhouse.dto.AccountDto;

public class AccountMapper {
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getAccountId(), account.getCreationDate(),
				account.getUnderAccountId(), account.getAccountType());
		return accountDto;
	}

	public static Account mapToAccount(AccountDto accountDto) {

		Account account = new Account(accountDto.getAccountId(), accountDto.getCreationDate(),
				accountDto.getUnderAccountId(), accountDto.getAccountType());
		return account;
	}

}
