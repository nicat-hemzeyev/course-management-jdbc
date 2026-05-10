package org.example.coursemanagementjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.coursemanagementjdbc.model.request.TeacherRequest;
import org.example.coursemanagementjdbc.model.response.TeacherResponse;
import org.example.coursemanagementjdbc.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public void createTeacher(@RequestBody TeacherRequest teacherRequest) {
        teacherService.createTeacher(teacherRequest);
    }

    @GetMapping
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);

    }

    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable int id, @RequestBody TeacherRequest teacherRequest) {
        teacherService.teacherUpdate(id, teacherRequest);
    }

    @DeleteMapping("/{id}")
    public void getTeacherDelete(@PathVariable int id) {
        teacherService.deleteTeacherById(id);
    }
}

