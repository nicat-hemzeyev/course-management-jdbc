package org.az.coursemanagementjdbc.mapper;

import org.az.coursemanagementjdbc.dao.entity.EnrollmentEntity;
import org.az.coursemanagementjdbc.model.request.EnrollmentRequest;
import org.az.coursemanagementjdbc.model.response.EnrollmentResponse;
import org.springframework.jdbc.core.RowMapper;

public class EnrollmentMapper {

    public static EnrollmentEntity mapToEntity(EnrollmentRequest enrollmentRequest) {
        return EnrollmentEntity.builder()
                .studentId(enrollmentRequest.getStudentId())
                .courseId(enrollmentRequest.getCourseId())
                .build();
    }
}
