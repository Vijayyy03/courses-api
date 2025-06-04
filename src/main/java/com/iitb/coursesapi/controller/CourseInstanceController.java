package com.iitb.coursesapi.controller;

import com.iitb.coursesapi.model.CourseInstance;
import com.iitb.coursesapi.repository.CourseInstanceRepository;
import com.iitb.coursesapi.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
@CrossOrigin(origins = "*")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceRepository instanceRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public CourseInstance createInstance(@Valid @RequestBody CourseInstance instance) {
        return instanceRepository.save(instance);
    }

    @GetMapping("/{year}/{semester}")
    public List<CourseInstance> getInstancesByYearAndSemester(
            @PathVariable Integer year,
            @PathVariable Integer semester) {
        return instanceRepository.findByYearAndSemester(year, semester);
    }

    @GetMapping("/{year}/{semester}/{id}")
    public ResponseEntity<CourseInstance> getInstanceById(
            @PathVariable Integer year,
            @PathVariable Integer semester,
            @PathVariable Long id) {
        return ResponseEntity.of(instanceRepository.findByYearAndSemesterAndId(year, semester, id));
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<?> deleteInstance(
            @PathVariable Integer year,
            @PathVariable Integer semester,
            @PathVariable Long id) {
        CourseInstance instance = instanceRepository.findByYearAndSemesterAndId(year, semester, id);
        if (instance != null) {
            instanceRepository.delete(instance);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
} 