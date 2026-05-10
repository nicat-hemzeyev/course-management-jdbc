package org.example.coursemanagementjdbc.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {
    private String name;
    private String surname;
    private BigDecimal salary;
}
