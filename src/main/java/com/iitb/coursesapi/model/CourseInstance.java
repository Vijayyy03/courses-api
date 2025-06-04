package com.iitb.coursesapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(2000)
    private Integer year;

    @NotNull
    @Min(1)
    private Integer semester;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
} 