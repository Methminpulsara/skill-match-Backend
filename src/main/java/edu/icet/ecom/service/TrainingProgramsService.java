package edu.icet.ecom.service;

import edu.icet.ecom.dto.TrainingProgram;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface TrainingProgramsService {

    TrainingProgram add(TrainingProgram trainingProgram);
    void delete(Long id);
    TrainingProgram update(Long id, TrainingProgram trainingProgram);
    TrainingProgram search(Long id);
    List<TrainingProgram> findByName(String name);
    List<TrainingProgram> getAll(Long companyId , String status);
    ResponseEntity<String> updateStatus(Long id);
}
