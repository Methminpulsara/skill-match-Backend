package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.TrainingProgram;
import edu.icet.ecom.entity.TrainingProgramEntity;
import edu.icet.ecom.repository.TrainingProgramsDto;
import edu.icet.ecom.service.TrainingProgramsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TrainingProgramsServiceImpl implements TrainingProgramsService {

    final TrainingProgramsDto dto;
    final ModelMapper mapper;

    @Override
    public TrainingProgram add(TrainingProgram trainingProgram) {
      TrainingProgramEntity entity = mapper.map(trainingProgram, TrainingProgramEntity.class);
      entity = dto.save(entity);
      return mapper.map(entity,TrainingProgram.class);
    }

    @Override
    public void delete(Long id) {
        dto.deleteById(id);
    }

    @Override
    public void update(TrainingProgram trainingProgram) {
        dto.save(mapper.map(trainingProgram, TrainingProgramEntity.class));
    }

    @Override
    public TrainingProgram search(Long id) {
        return mapper.map(dto.findById(id), TrainingProgram.class);
    }

    @Override
    public List<TrainingProgram> findByName(String name) {

        List<TrainingProgram> programList = new ArrayList<>();
        List<TrainingProgramEntity> allByName = dto.findAllByName(name);
        allByName.forEach(trainingProgramEntity -> {
            programList.add(mapper.map(trainingProgramEntity, TrainingProgram.class));
        });
        return programList;
    }

    @Override
    public List<TrainingProgram> getAll(Long companyId, String status) {
        List<TrainingProgram> programList = new ArrayList<>();
        List<TrainingProgramEntity> all = dto.findAllByCompanyCompanyIdAndStatus(companyId , status);
        all.forEach(trainingProgramEntity -> {
            programList.add(mapper.map(trainingProgramEntity, TrainingProgram.class));
        });
        return programList;
    }
}
