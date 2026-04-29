package com.college.controller;

import com.college.entity.Course;
import com.college.entity.Enrollment;
import com.college.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody Enrollment enrollment) {
        Enrollment savedEnrollment = enrollmentService.enrollStudent(enrollment);
        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
    }

    @PutMapping("/grade")
    public ResponseEntity<Enrollment> updateGrade(@RequestParam Long studentId,
                                                   @RequestParam Long courseId,
                                                   @RequestParam String grade) {
        Enrollment updatedEnrollment = enrollmentService.updateGrade(studentId, courseId, grade);
        return new ResponseEntity<>(updatedEnrollment, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByDate(date);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/instructor/{instructor}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByInstructor(@PathVariable String instructor) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByInstructor(instructor);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/highest")
    public ResponseEntity<Course> getCourseWithHighestEnrollments() {
        Course course = enrollmentService.getCourseWithHighestEnrollments();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }
}
