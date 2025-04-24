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
        return service.add(program);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update (@RequestBody TrainingProgram program){
        if(program==null){
            return ResponseEntity.badRequest().body("program data missing");
        }
        service.update(program);
        return ResponseEntity.ok("updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (id == null){
            return ResponseEntity.badRequest().body("not pass id");
        }
        service.delete(id);
        return ResponseEntity.ok("Skill deleted !");
    }

    @GetMapping("/active/programs/{companyId}")
    public List<TrainingProgram> getAllCompanyPrograms(@PathVariable Long companyId){
        return service.getAll(companyId, "active");
    }

    @GetMapping("/search/{id}")
    public TrainingProgram search(@PathVariable Long id){
        return service.search(id);
    }

    @GetMapping("/searchName/{name}")
    public List<TrainingProgram> findByName(@PathVariable String name){
        return service.findByName(name);
    }
}
