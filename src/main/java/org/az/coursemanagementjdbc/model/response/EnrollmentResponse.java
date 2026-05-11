package org.az.coursemanagementjdbc.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentResponse {
    private int studentId;
    private int courseId;
    private LocalDateTime enrollmentDate;
}
