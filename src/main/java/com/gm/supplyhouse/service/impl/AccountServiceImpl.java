package com.gm.supplyhouse.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gm.supplyhouse.data.Account;
import com.gm.supplyhouse.data.Invitation;
import com.gm.supplyhouse.dto.AccountDto;
import com.gm.supplyhouse.mapper.AccountMapper;
import com.gm.supplyhouse.repository.AccountRepository;
import com.gm.supplyhouse.repository.InviteRespository;
import com.gm.supplyhouse.repository.OrderRepository;
import com.gm.supplyhouse.service.AccountService;
import com.gm.supplyhouse.utils.AppUtilities;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	
	private OrderRepository orderRepository;
	private InviteRespository inviteRespository;
	
	
	
	@Override
	public AccountDto saveAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		AccountDto savedAccountDto = AccountMapper.mapToAccountDto(savedAccount);
		return savedAccountDto;

	}

	@Override
	public AccountDto getAccount(int accountId) {
		Optional<Account> optionalAccount = Optional.ofNullable(accountRepository.getById(accountId));
		AccountDto accountDto = AccountMapper.mapToAccountDto(optionalAccount.get());
		return accountDto;
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accountList = accountRepository.findAll();
		List<AccountDto> accountListDto = accountList.stream().map(AccountMapper::mapToAccountDto)
				.collect(Collectors.toList());
		return accountListDto;
	}

	@Override
	public String upgradeAccount(int accountId) {
		Account account = accountRepository.findById(accountId).get();
		long orderCount = orderRepository.countByAccountId(accountId);

		if (orderCount > AppUtilities.UPGRADE_COUNT) {
			account.setUnderAccountId(0);
			account.setAccountType("O");
			accountRepository.save(account);
			return "Account Upgraded to Business Owner";
		} else {
			return "Account not eligible for upgrade to Business Owner";
		}
	}

	public String sendInviteToJoin(int accountId) {
		List<Account> inviteAccountList = accountRepository.findByAccountType("S");
		if (inviteAccountList.size() > 0) {
			for(Account account : inviteAccountList)
			{
				Invitation invitation = new Invitation();
				invitation.setSenderId(accountId);
				invitation.setReceiverId(account.getAccountId());
				invitation.setStatus("New");
				inviteRespository.save(invitation);
			}
			return "Invite sent successfully";
		} else {
			return "Unable to send invite";
		}
	}

}
