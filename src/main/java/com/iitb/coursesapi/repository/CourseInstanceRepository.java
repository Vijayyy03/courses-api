package com.iitb.coursesapi.repository;

import com.iitb.coursesapi.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(Integer year, Integer semester);
    CourseInstance findByYearAndSemesterAndId(Integer year, Integer semester, Long id);
} 