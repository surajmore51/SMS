package com.suraj.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suraj.sms.entities.School;

@Repository
public interface SchoolRepo extends JpaRepository<School, Integer> {

}
