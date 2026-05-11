package org.az.coursemanagementjdbc.mapper;

import org.az.coursemanagementjdbc.dao.entity.EnrollmentEntity;
import org.az.coursemanagementjdbc.model.request.EnrollmentRequest;
import org.az.coursemanagementjdbc.model.response.EnrollmentResponse;
import org.springframework.jdbc.core.RowMapper;

public class EnrollmentMapper {
    public static final RowMapper<EnrollmentEntity> MAPPER = ((rs, rowNum) ->
            EnrollmentEntity.builder()
                    .studentId(rs.getInt("student_id"))
                    .courseId(rs.getInt("course_id"))
                    .enrollmentDate(rs.getTimestamp("enrollment_date").toLocalDateTime())
                    .build());

    public static EnrollmentEntity mapToEntity(EnrollmentRequest enrollmentRequest) {
        return EnrollmentEntity.builder()
                .studentId(enrollmentRequest.getStudentId())
                .courseId(enrollmentRequest.getCourseId())
                .build();
    }

    public static EnrollmentResponse mapToDto(EnrollmentEntity enrollmentEntity) {
        return EnrollmentResponse.builder()
                .studentId(enrollmentEntity.getStudentId())
                .courseId(enrollmentEntity.getCourseId())
                .enrollmentDate(enrollmentEntity.getEnrollmentDate())
                .build();
    }
}
