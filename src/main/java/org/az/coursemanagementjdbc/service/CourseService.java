package org.az.coursemanagementjdbc.service;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.dao.entity.CourseEntity;
import org.az.coursemanagementjdbc.dao.repository.CourseRepository;
import org.az.coursemanagementjdbc.mapper.CourseMapper;
import org.az.coursemanagementjdbc.model.request.CourseRequest;
import org.az.coursemanagementjdbc.model.response.CourseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    public final CourseRepository courseRepository;

    public void createCourse(CourseRequest courseRequest) {
        CourseEntity course = CourseMapper.mapToEntity(courseRequest);
        courseRepository.save(course);
    }

    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper::mapToDto)
                .toList();
    }

    public CourseResponse getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(CourseMapper::mapToDto)
                .orElseThrow(() -> new RuntimeException("course not found"));
    }

    public void courseUpdate(Long id, CourseRequest courseRequest) {
        CourseEntity course = CourseMapper.mapToEntity(courseRequest);
        course.setId(id);
        courseRepository.update(course);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}
