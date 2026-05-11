package org.example.coursemanagementjdbc.dao.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TableRepository {
    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        createStudentsTable();
        createTeachersTable();
        createCoursesTable();
        createEnroolmentsTable();
    }

    public void createCoursesTable() {
        var sql = ("""
                CREATE TABLE IF NOT EXISTS courses(
                   id SERIAL  PRIMARY KEY NOT NULL,
                   name VARCHAR(100) NOT NULL,
                    teacher_id INT REFERENCES teachers(id)
                );
                """);
        jdbcTemplate.execute(sql);
    }

    public void createStudentsTable() {
        var sql = """ 
                CREATE TABLE IF NOT EXISTS students(
                    id SERIAL PRIMARY KEY NOT NULL,
                    name VARCHAR(100) NOT NULL,
                    surname VARCHAR(100) NOT NULL,
                    grade NUMERIC
                );
                """;
        jdbcTemplate.execute(sql);
    }

    public void createTeachersTable() {
        var sql = ("""
                CREATE TABLE IF NOT EXISTS teachers(
                id SERIAL PRIMARY KEY NOT NULL,
                name VARCHAR(100) NOT NULL,
                surname VARCHAR(100) NOT NULL,
                salary NUMERIC
                );
                """);
        jdbcTemplate.execute(sql);
    }

    public void createEnroolmentsTable() {
        var sql = ("""
                CREATE TABLE IF NOT EXISTS enrolments(
                student_id INT REFERENCES students(id),
                course_id INT REFERENCES courses(id),
                enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                );
                """);
        jdbcTemplate.execute(sql);
    }
}
