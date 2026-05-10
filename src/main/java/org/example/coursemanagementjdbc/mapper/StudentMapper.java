package org.example.coursemanagementjdbc.mapper;

import org.example.coursemanagementjdbc.dao.entity.StudentEntity;
import org.example.coursemanagementjdbc.model.request.StudentRequest;
import org.example.coursemanagementjdbc.model.response.StudentResponse;
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
//mapToEntity → Request obyektini götürüb Entity-yə çevirir.
        return StudentEntity.builder()
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .grade(studentRequest.getGrade())
                .build();
    }

    //Entity → DB-dən gələn obyekt (məsələn, StudentEntity).
//Amma biz API cavabında birbaşa Entity göndərmirik, çünki:
//Entity-də lazımsız və ya gizli sahələr ola bilər (məsələn, password, createdAt).
//DTO (Data Transfer Object) → yalnız lazım olan məlumatları client-ə qaytarır.
//mapToDto → Entity obyektini Response DTO-ya (StudentResponse) çevirir.
    public static StudentResponse mapToDto(StudentEntity studentEntity) {
        return StudentResponse.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .grade(studentEntity.getGrade())
                .build();
    }
}
