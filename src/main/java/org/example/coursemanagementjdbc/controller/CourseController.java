package org.example.coursemanagementjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.coursemanagementjdbc.model.request.CourseRequest;
import org.example.coursemanagementjdbc.model.response.CourseResponse;
import org.example.coursemanagementjdbc.service.CourseService;
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
    public CourseResponse getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public void courseUpdate(@PathVariable int id, @RequestBody CourseRequest courseRequest) {
        courseService.courseUpdate(id, courseRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable int id) {
        courseService.deleteCourseById(id);
    }
}
