package edu.icet.ecom.controller;

import edu.icet.ecom.dto.CareerSuggestion;
import edu.icet.ecom.service.CareerSuggestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career-suggestion")
@CrossOrigin
@RequiredArgsConstructor
public class CareerSuggestionController {

    private final CareerSuggestionService service;

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<CareerSuggestion>> getSuggestion(@PathVariable Long employeeId){
        List<CareerSuggestion>  suggestions = service.careerSuggestions(employeeId);
        return ResponseEntity.ok(suggestions);

    }

}
