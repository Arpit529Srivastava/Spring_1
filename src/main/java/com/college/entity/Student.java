package com.college.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private Long studentId;

    private String name;
    private String email;
    private String department;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "student-enrollment")
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student() {
    }

    public Student(Long studentId, String name, String email, String department) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
