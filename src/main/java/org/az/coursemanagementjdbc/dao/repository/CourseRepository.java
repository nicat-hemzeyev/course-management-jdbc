package org.az.coursemanagementjdbc.dao.repository;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.dao.entity.CourseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.az.coursemanagementjdbc.mapper.CourseMapper.MAPPER;

@Repository
@RequiredArgsConstructor
public class CourseRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(CourseEntity courseEntity) {
        String sql = "INSERT INTO courses (name,teacher_id) VALUES(?,?)";
        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(sql);
            ps.setString(1, courseEntity.getName());
            ps.setInt(2,courseEntity.getTeacherId());
            return ps;
        });
    }

    public Optional<CourseEntity> findById(int id) {
        String sql = "SELECT*FROM courses WHERE id=?";
        try {
            CourseEntity course = jdbcTemplate.queryForObject(sql, MAPPER, id);
            return Optional.ofNullable(course);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<CourseEntity> findAll(){
        String sql ="INSERT*FROM courses";
        return jdbcTemplate.query(sql,MAPPER);
    }

    public void update(CourseEntity courseEntity){
        String sql ="UPDATE courses SET name=?,teacher_id=? WHERE id=?";
        jdbcTemplate.update(sql,
                courseEntity.getName(),
                courseEntity.getTeacherId(),
                courseEntity.getId()
        );
    }

    public void deleteById(int id){
        String sql ="DELETE FROM courses WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
}
