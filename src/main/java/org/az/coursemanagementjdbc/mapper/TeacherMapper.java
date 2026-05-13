package org.az.coursemanagementjdbc.mapper;

import org.az.coursemanagementjdbc.dao.entity.TeacherEntity;
import org.az.coursemanagementjdbc.model.request.TeacherRequest;
import org.az.coursemanagementjdbc.model.response.TeacherResponse;
import org.springframework.jdbc.core.RowMapper;

public class TeacherMapper {
    public static final RowMapper<TeacherEntity> MAPPER = ((rs, rowNum) ->
            TeacherEntity.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .surname(rs.getString("surname"))
                    .salary(rs.getBigDecimal("salary"))
                    .build());

    public static TeacherEntity mapToEntity(TeacherRequest teacherRequest) {
        return TeacherEntity.builder()
                .name(teacherRequest.getName())
                .surname(teacherRequest.getSurname())
                .salary(teacherRequest.getSalary())
                .build();
    }

    public static TeacherResponse mapToDto(TeacherEntity teacherEntity) {
        return TeacherResponse.builder()
                .id(teacherEntity.getId())
                .name(teacherEntity.getName())
                .surname(teacherEntity.getSurname())
                .salary(teacherEntity.getSalary())
                .build();
    }
}
