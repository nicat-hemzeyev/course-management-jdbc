package org.example.coursemanagementjdbc.mapper;

import org.example.coursemanagementjdbc.dao.entity.CourseEntity;
import org.example.coursemanagementjdbc.model.request.CourseRequest;
import org.example.coursemanagementjdbc.model.response.CourseResponse;
import org.springframework.jdbc.core.RowMapper;

public class CourseMapper {
    public static final RowMapper<CourseEntity> MAPPER = ((rs, rowNum) ->
            CourseEntity.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .teacherId(rs.getInt("teacher_id"))
                    .build());

    public static CourseEntity mapToEntity(CourseRequest courseRequest) {
        return CourseEntity.builder()
                .name(courseRequest.getName())
                .teacherId(courseRequest.getTeacherId())
                .build();
    }

    public static CourseResponse mapToDto(CourseEntity courseEntity) {
        return CourseResponse.builder()
                .id(courseEntity.getId())
                .name(courseEntity.getName())
                .teacherId(courseEntity.getTeacherId())
                .build();
    }
}
