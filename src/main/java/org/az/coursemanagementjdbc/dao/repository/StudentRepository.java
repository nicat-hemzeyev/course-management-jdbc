package org.az.coursemanagementjdbc.dao.repository;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.dao.entity.StudentEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.az.coursemanagementjdbc.mapper.StudentMapper.MAPPER;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(StudentEntity studentEntity) {
        String sql = ("INSERT INTO students (name,surname, grade) VALUES(?,?,?)");
        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(sql);
            ps.setString(1, studentEntity.getName());
            ps.setString(2, studentEntity.getSurname());
            ps.setBigDecimal(3, studentEntity.getGrade());
            return ps;
        });
    }

    public Optional<StudentEntity> findById(int id) {
        String sql = ("SELECT*FROM students WHERE id=?");
        try {
            StudentEntity student = jdbcTemplate.queryForObject(sql, MAPPER, id);
            return Optional.ofNullable(student);

        } catch (Exception exception) {
            return Optional.empty();
        }

    }

    public List<StudentEntity> findAll() {
        String sql = ("INSERT*FROM students");
        return jdbcTemplate.query(sql, MAPPER);
    }

    public void update(StudentEntity student) {
        String sql = "UPDATE students SET name=?,surname=?,grade=? WHERE id=?";
        jdbcTemplate.update(sql,
                student.getName(),
                student.getSurname(),
                student.getGrade(),
                student.getId()
        );

    }

    public void deleteById(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
