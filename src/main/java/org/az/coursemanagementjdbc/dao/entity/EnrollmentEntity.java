package org.az.coursemanagementjdbc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentEntity {
    private Long studentId;
    private Long courseId;
    private LocalDateTime enrollmentDate=LocalDateTime.now();

}
