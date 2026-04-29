package com.college.repository;

import com.college.entity.Enrollment;
import com.college.entity.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {

    List<Enrollment> findByEnrollmentDate(LocalDate enrollmentDate);

    @Query("SELECT e FROM Enrollment e JOIN Course c ON e.id.courseId = c.courseId WHERE c.instructor = :instructor")
    List<Enrollment> findByInstructor(@Param("instructor") String instructor);

    @Query("SELECT e.id.courseId, COUNT(e) as cnt FROM Enrollment e GROUP BY e.id.courseId ORDER BY cnt DESC")
    List<Object[]> findCourseWithHighestEnrollments();
}
