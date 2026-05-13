package org.az.coursemanagementjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.model.request.EnrollmentRequest;
import org.az.coursemanagementjdbc.service.EnrollmentService;
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
    public void unenroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        enrollmentService.unenroll(studentId, courseId);
    }

    @GetMapping("/{studentId}/{courseId}")
    public boolean isEnrollment(@PathVariable Long studentId, @PathVariable Long courseId) {
       return enrollmentService.isEnrolled(studentId, courseId);
    }

}
