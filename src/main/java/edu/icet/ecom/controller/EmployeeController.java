package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
@RequiredArgsConstructor

public class EmployeeController {
    final EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<Employee> add (@RequestBody Employee employee){
        employee.setEmployeeId(null);
        return ResponseEntity.ok(service.add(employee));
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

    @GetMapping("/all/{companyId}")
    List<Employee> getAll(@PathVariable Long companyId){
        return service.getAll( companyId);
    }

    @GetMapping("/{id}")
    public Employee search(@PathVariable Long id){
        return service.search(id);
    }

    @GetMapping("/name/{name}")
    public Employee searchByName(@PathVariable String name){
        return service.searchByName(name);
    }

    @GetMapping("/user/{userID}")
    public Employee searchByUserID(@PathVariable Long userID){
        return service.findByUserID(userID);
    }


    @PutMapping("/{employeeId}/profile-image")
    public Employee updateProfileImage(
            @PathVariable Long employeeId,
            @RequestBody  String profileImage) {

    return service.updateProfileImage(employeeId,profileImage);
    }

    @PutMapping("/update/{employeeId}")
    public Employee updateEmployeeDetails(@PathVariable Long companyId, @RequestBody Employee employee) {
        return service.updateEmployeeDetails(companyId, employee);
    }




}
