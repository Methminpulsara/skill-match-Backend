package edu.icet.ecom.controller;


import edu.icet.ecom.dto.Company;
import edu.icet.ecom.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/company")
@CrossOrigin
@RequiredArgsConstructor

public class CompanyController {

    final CompanyService service;

    @PostMapping("/add")
    public ResponseEntity<String> add (@RequestBody Company company){
        if (company==null){
            return ResponseEntity.badRequest().body("Company data missing");
        }
        service.add(company);
        return ResponseEntity.ok( "Added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update (@RequestBody Company company){
        if(company==null){
            return ResponseEntity.badRequest().body("company data missing");
        }
        service.update(company);
        return ResponseEntity.ok("updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (id == null){
            return ResponseEntity.badRequest().body("not pass id");
        }
        service.delete(id);
        return ResponseEntity.ok("Company deleted !");
    }

    @GetMapping("/all")
    List<Company> getAll(){
      return service.getAll();
    }

    @GetMapping("/search/{id}")
    public Company search(Long id){
        return service.search(id);
    }

    @GetMapping("/search/{name}")
    public Company searchByName(String name){
        return service.searchByName(name);
    }




}
