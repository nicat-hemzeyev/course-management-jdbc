package org.az.coursemanagementjdbc.service;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.dao.entity.TeacherEntity;
import org.az.coursemanagementjdbc.dao.repository.TeacherRepository;
import org.az.coursemanagementjdbc.mapper.TeacherMapper;
import org.az.coursemanagementjdbc.model.request.TeacherRequest;
import org.az.coursemanagementjdbc.model.response.TeacherResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    public final TeacherRepository teacherRepository;

    public void createTeacher(TeacherRequest teacherRequest) {
        TeacherEntity teacherEntity = TeacherMapper.mapToEntity(teacherRequest);
        teacherRepository.save(teacherEntity);
    }

    public List<TeacherResponse> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper::mapToDto)
                .toList();
    }

    public TeacherResponse getTeacherById(int id) {
        return teacherRepository.findById(id)
                .map(TeacherMapper::mapToDto)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public void teacherUpdate(int id, TeacherRequest teacherRequest) {
        TeacherEntity teacherEntity = TeacherMapper.mapToEntity(teacherRequest);
        teacherEntity.setId(id);
        teacherRepository.update(teacherEntity);
    }

    public void deleteTeacherById(int id) {
        teacherRepository.deleteById(id);
    }
}
