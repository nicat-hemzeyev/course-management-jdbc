package org.example.coursemanagementjdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.coursemanagementjdbc.dao.entity.StudentEntity;
import org.example.coursemanagementjdbc.dao.repository.StudentRepository;
import org.example.coursemanagementjdbc.mapper.StudentMapper;
import org.example.coursemanagementjdbc.model.request.StudentRequest;
import org.example.coursemanagementjdbc.model.response.StudentResponse;
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

    public StudentResponse getStudentById(int id) {
        return studentRepository.findById(id)
                .map(StudentMapper::mapToDto)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void studentUpdate(int id, StudentRequest studentRequest) {
        StudentEntity studentEntity = StudentMapper.mapToEntity(studentRequest);
        studentEntity.setId(id);
        studentRepository.update(studentEntity);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);

    }
}
