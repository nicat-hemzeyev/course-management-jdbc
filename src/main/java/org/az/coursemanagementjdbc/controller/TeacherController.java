package org.az.coursemanagementjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.model.request.TeacherRequest;
import org.az.coursemanagementjdbc.model.response.TeacherResponse;
import org.az.coursemanagementjdbc.service.TeacherService;
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
    public TeacherResponse getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        teacherService.teacherUpdate(id, teacherRequest);
    }

    @DeleteMapping("/{id}")
    public void getTeacherDelete(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }
}

