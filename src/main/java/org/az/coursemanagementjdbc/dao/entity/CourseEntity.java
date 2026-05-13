package org.az.coursemanagementjdbc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseEntity {
    private Long id;
    private String name;
    private Long teacherId;
}
