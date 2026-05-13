package org.az.coursemanagementjdbc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {
    private Long id;
    private String name;
    private String surname;
    private BigDecimal grade;
}
