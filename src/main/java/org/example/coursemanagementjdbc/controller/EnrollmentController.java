package org.example.coursemanagementjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.coursemanagementjdbc.model.request.EnrollmentRequest;
import org.example.coursemanagementjdbc.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void enroll(@RequestBody EnrollmentRequest enrollmentRequest) {
        enrollmentService.enroll(enrollmentRequest);
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public void unenroll(@PathVariable int studentId, @PathVariable int courseId) {
        enrollmentService.unenroll(studentId, courseId);
    }

    @GetMapping("/{studentId}/{courseId}")
    public boolean isEnrollment(@PathVariable int studentId, @PathVariable int courseId) {
       return enrollmentService.isEnrolled(studentId, courseId);
    }

}
