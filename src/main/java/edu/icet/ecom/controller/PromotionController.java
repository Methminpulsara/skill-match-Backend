package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Promotion;
import edu.icet.ecom.dto.Skill;
import edu.icet.ecom.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/promotion")
@CrossOrigin
@RequiredArgsConstructor

public class PromotionController {

    final PromotionService service;

    @PostMapping("/add")
    public ResponseEntity<String> add (@RequestBody Promotion promotion){
        if (promotion==null){
            return ResponseEntity.badRequest().body("promotion data missing");
        }
        service.add(promotion);
        return ResponseEntity.ok( "Added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update (@RequestBody Promotion promotion){
        if(promotion==null){
            return ResponseEntity.badRequest().body("promotion data missing");
        }
        service.update(promotion);
        return ResponseEntity.ok("updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (id == null){
            return ResponseEntity.badRequest().body("not pass id");
        }
        service.delete(id);
        return ResponseEntity.ok("promotion deleted !");
    }

    @GetMapping("/all")
    public List<Promotion> getAll(){
        return service.getALl();
    }

    @GetMapping("/search/{id}")
    public Promotion search(@PathVariable Long id){
        return service.search(id);
    }

    @GetMapping("/searchName/{name}")
    public Promotion searchByName(@PathVariable String name){
        return service.searchByName(name);
    }
}
