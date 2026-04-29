package com.college.service;

import com.college.entity.Course;
import com.college.entity.Enrollment;
import com.college.entity.EnrollmentId;
import com.college.exception.ResourceNotFoundException;
import com.college.repository.CourseRepository;
import com.college.repository.EnrollmentRepository;
import com.college.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment enrollStudent(Enrollment enrollment) {
        Long studentId = enrollment.getId().getStudentId();
        Long courseId = enrollment.getId().getCourseId();

        if (!studentRepository.existsById(studentId)) {
            throw new ResourceNotFoundException("Student not found with id: " + studentId);
        }
        if (!courseRepository.existsById(courseId)) {
            throw new ResourceNotFoundException("Course not found with id: " + courseId);
        }

        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateGrade(Long studentId, Long courseId, String grade) {
        EnrollmentId enrollmentId = new EnrollmentId(studentId, courseId);

        if (!studentRepository.existsById(studentId)) {
            throw new ResourceNotFoundException("Student not found with id: " + studentId);
        }
        if (!courseRepository.existsById(courseId)) {
            throw new ResourceNotFoundException("Course not found with id: " + courseId);
        }

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Enrollment not found for studentId: " + studentId + " and courseId: " + courseId));

        enrollment.setGrade(grade);
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByDate(LocalDate date) {
        return enrollmentRepository.findByEnrollmentDate(date);
    }

    public List<Enrollment> getEnrollmentsByInstructor(String instructor) {
        return enrollmentRepository.findByInstructor(instructor);
    }

    public Course getCourseWithHighestEnrollments() {
        List<Object[]> results = enrollmentRepository.findCourseWithHighestEnrollments();
        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No enrollments found");
        }
        Long courseId = (Long) results.get(0)[0];
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
