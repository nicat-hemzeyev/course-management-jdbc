package org.az.coursemanagementjdbc.dao.repository;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.dao.entity.EnrollmentEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EnrollmentRepository {
    private final JdbcTemplate jdbcTemplate;

    public void enrol(EnrollmentEntity enrollmentEntity) {
        String sql = "INSERT INTO enrolments(student_id ,course_id) VALUES(?,?)";

        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(sql);
            ps.setLong(1, enrollmentEntity.getStudentId());
            ps.setLong(2, enrollmentEntity.getCourseId());
            return ps;
        });
    }

    public void unenroll(Long studentId, Long courseId) {
        String sql = "DELETE FROM enrolments WHERE student_id=? AND course_id=?";
        jdbcTemplate.update(sql, studentId, courseId);
    }

    public boolean isEnrolled(Long studentId, Long courseId) {
        String sql = "SELECT COUNT (*) FROM enrolments WHERE student_id=? AND course_id=?";
        Long count = jdbcTemplate.queryForObject(sql, Long.class, studentId, courseId);
        return count != null && count > 0;
    }
}
