package com.gm.supplyhouse.service;

import com.gm.supplyhouse.data.Account;

public interface  InviteService {
	
public void  sendInviteToJoin(int senderAccountId, Account receiver);
}
