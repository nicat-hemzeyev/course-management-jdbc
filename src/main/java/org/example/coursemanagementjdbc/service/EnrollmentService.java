package org.example.coursemanagementjdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.coursemanagementjdbc.dao.repository.EnrollmentRepository;
import org.example.coursemanagementjdbc.model.request.EnrollmentRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    public final EnrollmentRepository enrollmentRepository;

    public void enroll(EnrollmentRequest enrollmentRequest){

    }
}
