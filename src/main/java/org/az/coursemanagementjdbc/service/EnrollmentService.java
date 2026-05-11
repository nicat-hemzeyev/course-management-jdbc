package org.az.coursemanagementjdbc.service;

import lombok.RequiredArgsConstructor;
import org.az.coursemanagementjdbc.dao.entity.EnrollmentEntity;
import org.az.coursemanagementjdbc.dao.repository.EnrollmentRepository;
import org.az.coursemanagementjdbc.mapper.EnrollmentMapper;
import org.az.coursemanagementjdbc.model.request.EnrollmentRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    public final EnrollmentRepository enrollmentRepository;

    public void enroll(EnrollmentRequest enrollmentRequest){
        EnrollmentEntity enrollmentEntity = EnrollmentMapper.mapToEntity(enrollmentRequest);
        enrollmentEntity.setEnrollmentDate(LocalDateTime.now());
        enrollmentRepository.enrol(enrollmentEntity);
    }

    public void unenroll(int studentId, int courseId) {
        enrollmentRepository.unenroll(studentId, courseId);

    }

    public boolean isEnrolled(int studentId, int CourseId) {
        return enrollmentRepository.isEnrolled(studentId, CourseId);
    }
}
