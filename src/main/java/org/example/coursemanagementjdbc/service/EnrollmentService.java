package org.example.coursemanagementjdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.coursemanagementjdbc.dao.entity.EnrollmentEntity;
import org.example.coursemanagementjdbc.dao.repository.EnrollmentRepository;
import org.example.coursemanagementjdbc.mapper.EnrollmentMapper;
import org.example.coursemanagementjdbc.model.request.EnrollmentRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    public final EnrollmentRepository enrollmentRepository;

    public void enroll(EnrollmentRequest enrollmentRequest){
        EnrollmentEntity enrollmentEntity = EnrollmentMapper.mapToEntity(enrollmentRequest);
        enrollmentRepository.enrol(enrollmentEntity);
    }

    public void unenroll(int studentId, int courseId) {
        enrollmentRepository.unenroll(studentId, courseId);

    }

    public boolean isEnrolled(int studentId, int CourseId) {
        return enrollmentRepository.isEnrolled(studentId, CourseId);
    }
}
