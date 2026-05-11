package org.az.coursemanagementjdbc.mapper;

import org.az.coursemanagementjdbc.dao.entity.StudentEntity;
import org.az.coursemanagementjdbc.model.request.StudentRequest;
import org.az.coursemanagementjdbc.model.response.StudentResponse;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper {
    public static final RowMapper<StudentEntity> MAPPER = ((rs, rowNum) ->
            StudentEntity.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .surname(rs.getString("surname"))
                    .grade(rs.getBigDecimal("grade"))
                    .build());

    public static StudentEntity mapToEntity(StudentRequest studentRequest) {
        return StudentEntity.builder()
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .grade(studentRequest.getGrade())
                .build();
    }

    public static StudentResponse mapToDto(StudentEntity studentEntity) {
        return StudentResponse.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .grade(studentEntity.getGrade())
                .build();
    }
}
