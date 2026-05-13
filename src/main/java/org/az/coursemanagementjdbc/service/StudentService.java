package org.az.coursemanagementjdbc.service;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.dao.entity.StudentEntity;
import org.az.coursemanagementjdbc.dao.repository.StudentRepository;
import org.az.coursemanagementjdbc.mapper.StudentMapper;
import org.az.coursemanagementjdbc.model.request.StudentRequest;
import org.az.coursemanagementjdbc.model.response.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    public final StudentRepository studentRepository;

    public void createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = StudentMapper.mapToEntity(studentRequest);
        studentRepository.save(studentEntity);
    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::mapToDto)
                .toList();
    }

    public StudentResponse getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(StudentMapper::mapToDto)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void studentUpdate(Long id, StudentRequest studentRequest) {
        StudentEntity studentEntity = StudentMapper.mapToEntity(studentRequest);
        studentEntity.setId(id);
        studentRepository.update(studentEntity);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);

    }
}
