package com.gm.supplyhouse.data;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Table(name = "invitations")
@Entity
public class Invitation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invite_id")
	private int inviteId;
	@Column(name = "sender_id")
	private int senderId;
	@Column(name = "receiver_id")
	private int receiverId;
	@Column(name = "status")
	private String status;

}
