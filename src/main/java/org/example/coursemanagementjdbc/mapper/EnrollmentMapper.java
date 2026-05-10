package org.example.coursemanagementjdbc.mapper;

import org.example.coursemanagementjdbc.dao.entity.EnrollmentEntity;
import org.example.coursemanagementjdbc.model.request.EnrollmentRequest;
import org.example.coursemanagementjdbc.model.response.EnrollmentResponse;
import org.springframework.jdbc.core.RowMapper;

public class EnrollmentMapper {
    public static final RowMapper<EnrollmentEntity> MAPPER = ((rs, rowNum) ->
            EnrollmentEntity.builder()
                    .studentId(rs.getInt("student_id"))
                    .courseId(rs.getInt("course_id"))
                    .enrolmentDate(rs.getDate("enrolment_date"))
                    .build()
    );

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
                .enrolmentDate(enrollmentEntity.getEnrolmentDate())
                .build();
    }
}
