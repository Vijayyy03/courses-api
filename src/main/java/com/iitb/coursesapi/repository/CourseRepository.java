package com.iitb.coursesapi.repository;

import com.iitb.coursesapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
} 