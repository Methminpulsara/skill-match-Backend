package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.EnrollmentsForTraining;
import edu.icet.ecom.entity.EnrollmentsForTrainingEntity;
import edu.icet.ecom.repository.EnrolledMeantDto;
import edu.icet.ecom.service.EnrolledMeantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrolledMeantServiceImpl implements EnrolledMeantService {

    private final EnrolledMeantDto enrolledMeantDto;
    private final ModelMapper mapper;

    @Override
    public EnrollmentsForTraining enroll(EnrollmentsForTraining enrollments) {

        EnrollmentsForTrainingEntity entity = mapper.map(enrollments, EnrollmentsForTrainingEntity.class);
        entity=enrolledMeantDto.save(entity);
        return mapper.map(entity,EnrollmentsForTraining.class);
    }

    @Override
    public boolean isAlreadyEnrolled(Long employeeId, Long trainingId) {
        return enrolledMeantDto.findByEmployeeIdAndTrainingId(employeeId, trainingId).isPresent();
    }

    public List<EnrollmentsForTraining> findByEmployeeId(Long employeeId) {

        List<EnrollmentsForTraining> enrollments = new ArrayList<>();
        List<EnrollmentsForTrainingEntity> byEmployeeId = enrolledMeantDto.findByEmployeeId(employeeId);
        byEmployeeId.forEach(entity->
                enrollments.add(mapper.map(entity,EnrollmentsForTraining.class)));
        return enrollments;
    }

    @Override
    public long getEmployeeCountForTraining(Long trainingId) {
        return enrolledMeantDto.countByTrainingId(trainingId);
    }
}
