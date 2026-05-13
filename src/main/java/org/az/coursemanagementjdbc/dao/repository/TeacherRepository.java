package org.az.coursemanagementjdbc.dao.repository;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.dao.entity.TeacherEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.az.coursemanagementjdbc.mapper.TeacherMapper.MAPPER;

@Repository
@RequiredArgsConstructor

public class TeacherRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(TeacherEntity teacherEntity) {
        String sql = "INSERT INTO teachers (name,surname,salary) VALUES(?,?,?)";
        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(sql);
            ps.setString(1, teacherEntity.getName());
            ps.setString(2, teacherEntity.getSurname());
            ps.setBigDecimal(3, teacherEntity.getSalary());
            return ps;
        });
    }

    public Optional<TeacherEntity> findById(Long id) {
        String sql = "SELECT*FROM teachers WHERE id=?";
        try {
            TeacherEntity teacher = jdbcTemplate.queryForObject(sql, MAPPER, id);
            return Optional.ofNullable(teacher);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<TeacherEntity> findAll() {
        String sql = "INSERT FROM teachers";
        return jdbcTemplate.query(sql, MAPPER);
    }

    public void update(TeacherEntity teacher) {
        String sql = "UPDATE teachers SET name=?,surname=?,salary=? WHERE id=?";
        jdbcTemplate.update(sql,
                teacher.getName(),
                teacher.getSurname(),
                teacher.getSalary(),
                teacher.getId());
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM teachers WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

}
