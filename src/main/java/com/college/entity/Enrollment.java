package com.college.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    @JsonBackReference(value = "student-enrollment")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    @JsonBackReference(value = "course-enrollment")
    private Course course;

    private LocalDate enrollmentDate;
    private String grade;
    private double attendancePercentage;

    public Enrollment() {
    }

    public Enrollment(EnrollmentId id, LocalDate enrollmentDate, String grade, double attendancePercentage) {
        this.id = id;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
        this.attendancePercentage = attendancePercentage;
    }

    public EnrollmentId getId() {
        return id;
    }

    public void setId(EnrollmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }
}
