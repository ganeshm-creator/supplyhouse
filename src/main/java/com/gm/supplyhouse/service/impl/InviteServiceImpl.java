package com.gm.supplyhouse.service.impl;

import org.springframework.stereotype.Service;

import com.gm.supplyhouse.data.Account;
import com.gm.supplyhouse.data.Invitation;
import com.gm.supplyhouse.repository.InviteRespository;
import com.gm.supplyhouse.service.InviteService;

import lombok.AllArgsConstructor;
@Service

public class InviteServiceImpl implements InviteService {
	private InviteRespository inviteRespository;

	public InviteServiceImpl(InviteRespository inviteRespository) {
		super();
		this.inviteRespository = inviteRespository;
	}

	@Override
	public void sendInviteToJoin(int senderAccountId, Account receiver) {
		Invitation invitation = new Invitation();
		invitation.setSenderId(senderAccountId);
		invitation.setReceiverId(receiver.getAccountId());
		invitation.setStatus("New");

		inviteRespository.save(invitation);

	}
}
