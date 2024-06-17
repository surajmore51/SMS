package com.suraj.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.sms.entities.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
