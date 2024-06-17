package com.suraj.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suraj.sms.entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
