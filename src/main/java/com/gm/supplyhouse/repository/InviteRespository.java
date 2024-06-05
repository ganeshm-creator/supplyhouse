package com.gm.supplyhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.supplyhouse.data.Invitation;
@Repository
public interface InviteRespository extends JpaRepository<Invitation , Integer> {

}
