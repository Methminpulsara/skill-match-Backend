package edu.icet.ecom.controller;


import edu.icet.ecom.dto.Company;
import edu.icet.ecom.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/company")
@CrossOrigin
@RequiredArgsConstructor

public class CompanyController {

        final CompanyService service;

        @PostMapping("/create")
        public ResponseEntity<Company> add (@RequestBody Company company){
            company.setCompanyId(null);
            return ResponseEntity.ok(service.add(company));
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

        @GetMapping("/active")
        List<Company> getAllActiveCompanies(){
          return service.getAllActiveCompanies();
        }

        @GetMapping("/search/{id}")
        public Company search(@PathVariable Long id){
            return service.search(id);
        }

        @GetMapping("/name/{name}")
        public Company searchByName(@PathVariable  String name){
            return service.searchByName(name);
        }

        @GetMapping("/user/{userId}")
        public Company findUserByUserID(@PathVariable Long userId){
            return service.findUserByUserID(userId);
        }

        @PutMapping("/{companyId}/profile-image")
        public Company updateProfileImage(
                @PathVariable Long companyId,
                @RequestBody  String profileImage) {

            return service.updateProfileImage(companyId,profileImage);
        }

    @PutMapping("/update/{companyId}")
    public Company updateCompanyDetails(@PathVariable Long companyId, @RequestBody Company company) {
        return service.updateCompanyDetails(companyId, company);
    }


}
