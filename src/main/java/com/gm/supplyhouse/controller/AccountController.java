package com.gm.supplyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gm.supplyhouse.dto.AccountDto;
import com.gm.supplyhouse.dto.OrderDto;
import com.gm.supplyhouse.service.AccountService;
import com.gm.supplyhouse.service.OrderService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {
	
	private AccountService accountService;
	
	private OrderService orderService;
	
	
	@PostMapping
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
		AccountDto savedAccountDto = accountService.saveAccount(accountDto);
		return new ResponseEntity<AccountDto>(savedAccountDto, HttpStatus.CREATED);
	}

	@GetMapping("{accountId}")
	public ResponseEntity<AccountDto> getAllAccounts( @PathVariable("accountId") int accountId) {
		AccountDto accountDto= accountService.getAccount(accountId);
		return new ResponseEntity<AccountDto>(accountDto, HttpStatus.CREATED);
	}

	
	@GetMapping("/get-accounts")
	public ResponseEntity<List<AccountDto>> getAllOrders() {
		List<AccountDto> accountList = accountService.getAllAccounts();
		return new ResponseEntity<List<AccountDto>>(accountList, HttpStatus.CREATED);
	}
//upgrade account a business owner if number of orders are more than 10 within one year
	@PutMapping("{accountId}")
	public ResponseEntity<String> upgradeAccount(@PathVariable("accountId") int accountId)
	{
		return new ResponseEntity<String>(accountService.upgradeAccount(accountId), null);
	}

	
//send invite to other accounts to join the business
	@GetMapping("/send-invite")
	public ResponseEntity<String> sendInvite( @RequestParam("accountId") int accountId) {
		String result = accountService.sendInviteToJoin(accountId);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	//separate table to store invitations where sender, receiver (currently logged in user), join or not 
	//if joined update the table account with respective information
	//if not, do not update the table 
	
	
	
	
	///send invitations to other members
	//logic should be after promotion of the account holder
	
	
	
	
	
	
//after receiving invitation accept or decline invitation
//accept

//decline

//unlink a sub account for --sub account

//unlink a sub account for main account

}
