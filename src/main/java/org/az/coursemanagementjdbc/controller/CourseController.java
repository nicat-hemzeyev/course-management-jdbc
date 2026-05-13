package org.az.coursemanagementjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.model.request.CourseRequest;
import org.az.coursemanagementjdbc.model.response.CourseResponse;
import org.az.coursemanagementjdbc.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@RequestBody CourseRequest courseRequest) {
        courseService.createCourse(courseRequest);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public void courseUpdate(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        courseService.courseUpdate(id, courseRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }
}
