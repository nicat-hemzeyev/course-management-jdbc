package org.example.coursemanagementjdbc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentEntity {
    private int studentId;
    private int courseId;
    private LocalDateTime enrollmentDate=LocalDateTime.now();

}
