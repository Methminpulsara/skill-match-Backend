package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Promotion;
import edu.icet.ecom.dto.SkillAnalytics;
import edu.icet.ecom.service.SkillAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/analytics")
@CrossOrigin
@RequiredArgsConstructor

public class SkillAnalyticsController {

    private final SkillAnalyticsService service;

    @PostMapping("/add")
    public ResponseEntity<String> add (@RequestBody SkillAnalytics analytics){
        if (analytics==null){
            return ResponseEntity.badRequest().body("analytics data missing");
        }

        return ResponseEntity.ok( "Added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update (@RequestBody SkillAnalytics analytics){
        if(analytics==null){
            return ResponseEntity.badRequest().body("analytics data missing");
        }
        service.update(analytics);
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
    public List<SkillAnalytics> getAll(){
        return service.getAll();
    }

    @GetMapping("/search/{id}")
    public SkillAnalytics search(@PathVariable Long id){
        return service.search(id);
    }


}
