package org.example.coursemanagementjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.coursemanagementjdbc.model.request.StudentRequest;
import org.example.coursemanagementjdbc.model.response.StudentResponse;
import org.example.coursemanagementjdbc.service.StudentService;
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
    public StudentResponse getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentRequest studentRequest) {
        studentService.studentUpdate(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    public void getStudentDelete(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

}
