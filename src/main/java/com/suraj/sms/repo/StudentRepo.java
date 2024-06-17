package com.suraj.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suraj.sms.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
