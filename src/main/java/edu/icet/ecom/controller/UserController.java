package edu.icet.ecom.controller;

import edu.icet.ecom.dto.User;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RequiredArgsConstructor

public class UserController {

    final UserService service;

    @PostMapping("/add")
    public ResponseEntity<String> add (@RequestBody User user){
        if (user==null){
            return ResponseEntity.badRequest().body("user data missing");
        }
        service.add(user);
        return ResponseEntity.ok( "Added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update (@RequestBody User user){
        if(user==null){
            return ResponseEntity.badRequest().body("user data missing");
        }
        service.update(user);
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


    //GET /users/search?userName=john&password=12345
    @GetMapping("/search")
    public User search(@RequestParam String email, @RequestParam String password){
        return service.search(email,password);
    }



}
