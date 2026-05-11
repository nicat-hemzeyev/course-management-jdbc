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
    private int id;
    private String name;
    private int teacherId;
}
