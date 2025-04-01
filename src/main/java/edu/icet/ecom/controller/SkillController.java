package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.dto.Skill;
import edu.icet.ecom.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
@CrossOrigin
@RequiredArgsConstructor

public class SkillController {

    final SkillService service;


    @PostMapping("/add")
    public ResponseEntity<String> add (@RequestBody Skill skill){
        if (skill==null){
            return ResponseEntity.badRequest().body("skill data missing");
        }
        service.add(skill);
        return ResponseEntity.ok( "Added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update (@RequestBody Skill skill){
        if(skill==null){
            return ResponseEntity.badRequest().body("employee data missing");
        }
        service.update(skill);
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

    @GetMapping("/all")
   public List<Skill> getAll(){
        return service.getAll();
    }

    @GetMapping("/search/{id}")
    public Skill search(@PathVariable Long id){
        return service.search(id);
    }

    @GetMapping("/searchName/{name}")
    public List<Skill> findByName(@PathVariable String name){
        return service.findByName(name);
    }
}
