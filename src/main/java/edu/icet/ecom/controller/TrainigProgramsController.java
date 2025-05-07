package edu.icet.ecom.controller;

import edu.icet.ecom.dto.TrainingProgram;
import edu.icet.ecom.service.TrainingProgramsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trainingPrograms")
@CrossOrigin
@RequiredArgsConstructor
public class TrainigProgramsController {

     final TrainingProgramsService service;

    @PostMapping("/create")
    public TrainingProgram add (@RequestBody TrainingProgram program){
        program.setTrainingId(null);
        program.setStatus("active");
        return service.add(program);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (id == null){
            return ResponseEntity.badRequest().body("not pass id");
        }
        service.delete(id);
        return ResponseEntity.ok("Skill deleted !");
    }

    @GetMapping("/programs/{companyId}")
    public List<TrainingProgram> getAllCompanyPrograms(@PathVariable Long companyId){
        return service.getAll(companyId,"active");
    }

    @GetMapping("/search/{id}")
    public TrainingProgram search(@PathVariable Long id){
        return service.search(id);
    }

    @GetMapping("/searchName/{name}")
    public List<TrainingProgram> findByName(@PathVariable String name){
        return service.findByName(name);
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable Long id){
       return service.updateStatus(id);
    }

    @PutMapping("/update/{id}")
    public TrainingProgram update (@PathVariable Long id , @RequestBody TrainingProgram program){
        return service.update(id ,program);
    }





}
