package org.az.coursemanagementjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.model.request.StudentRequest;
import org.az.coursemanagementjdbc.model.response.StudentResponse;
import org.az.coursemanagementjdbc.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentRequest studentRequest) {
        studentService.createStudent(studentRequest);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        studentService.studentUpdate(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    public void getStudentDelete(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

}
