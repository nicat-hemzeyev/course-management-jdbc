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
        String sql = "INSERT INTO enrolments(student_id ,course_id, enrollment_date) VALUES(?,?,?)";

        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(sql);
            ps.setInt(1, enrollmentEntity.getStudentId());
            ps.setInt(2, enrollmentEntity.getCourseId());
            ps.setTimestamp(3,java.sql.Timestamp.valueOf(enrollmentEntity.getEnrollmentDate()));
            return ps;
        });
    }

    public void unenroll(int studentId, int courseId) {
        String sql = "DELETE FROM enrolments WHERE student_id=? AND course_id=?";
        jdbcTemplate.update(sql, studentId, courseId);
    }

    public boolean isEnrolled(int studentId, int courseId) {
        String sql = "SELECT COUNT (*) FROM enrolments WHERE student_id=? AND course_id=?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, studentId, courseId);
        return count != null && count > 0;
    }
}
