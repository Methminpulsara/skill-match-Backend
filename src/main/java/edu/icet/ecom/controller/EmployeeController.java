package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Company;
import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.service.CompanyService;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
@RequiredArgsConstructor

public class EmployeeController {
    final EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity<String> add (@RequestBody Employee employee){
        if (employee==null){
            return ResponseEntity.badRequest().body("employee data missing");
        }
        service.add(employee);
        return ResponseEntity.ok( "Added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update (@RequestBody Employee employee){
        if(employee==null){
            return ResponseEntity.badRequest().body("employee data missing");
        }
        service.update(employee);
        return ResponseEntity.ok("updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (id == null){
            return ResponseEntity.badRequest().body("not pass id");
        }
        service.delete(id);
        return ResponseEntity.ok("employee deleted !");
    }

    @GetMapping("/all")
    List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/search/{id}")
    public Employee search(@PathVariable Long id){
        return service.search(id);
    }

    @GetMapping("/searchName/{name}")
    public Employee searchByName(@PathVariable String name){
        return service.searchByName(name);
    }
}
