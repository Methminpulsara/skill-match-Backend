package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.TrainingProgram;
import edu.icet.ecom.entity.TrainingProgramEntity;
import edu.icet.ecom.repository.TrainingProgramsDto;
import edu.icet.ecom.service.TrainingProgramsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TrainingProgramsServiceImpl implements TrainingProgramsService {

    private final TrainingProgramsDto dto;
    private final ModelMapper mapper;

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
    public TrainingProgram update(Long id, TrainingProgram trainingProgram) {

        TrainingProgramEntity entity = dto.findById(id)
                .orElseThrow(()->new RuntimeException("TrainingProgram not found"));
        entity.setName(trainingProgram.getName());
        entity.setBadges(trainingProgram.getBadges());
        entity.setDescription(trainingProgram.getDescription());
        entity.setStartDate(trainingProgram.getStartDate());
        entity.setEndDate(trainingProgram.getEndDate());
        dto.save(entity);

        TrainingProgramEntity updated  = dto.findById(id)
                .orElseThrow(()->new RuntimeException("TrainingProgram not found"));

        return mapper.map(updated, TrainingProgram.class);

    }

    @Override
    public TrainingProgram search(Long id) {
        return mapper.map(dto.findById(id), TrainingProgram.class);
    }

    @Override
    public List<TrainingProgram> findByName(String name) {

        List<TrainingProgram> programList = new ArrayList<>();
        List<TrainingProgramEntity> allByName = dto.findAllByName(name);
        allByName.forEach(trainingProgramEntity ->
            programList.add(mapper.map(trainingProgramEntity, TrainingProgram.class)));
        return programList;
    }

    @Override
    public List<TrainingProgram> getAll(Long companyId, String status) {
        List<TrainingProgram> programList = new ArrayList<>();
        List<TrainingProgramEntity> all = dto.findAllByCompanyCompanyIdAndStatus(companyId , status);
        all.forEach(trainingProgramEntity ->
            programList.add(mapper.map(trainingProgramEntity, TrainingProgram.class)));
        return programList;
    }

    @Override
    public ResponseEntity<String> updateStatus(Long id) {

        TrainingProgramEntity entity = dto.findById(id).
                orElseThrow(()->new RuntimeException("program not found"));

        entity.setStatus("Inactive");

        dto.save(entity);

        return ResponseEntity.ok("training was deleted");
    }


}
