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

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setUserId(null);
        return ResponseEntity.ok( service.add(user));
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


    @PostMapping("/loginrequest")
    public ResponseEntity<User> search(@RequestBody User request){
        User user = service.search(request.getEmail(),request.getPassword());
        return ResponseEntity.ok(user);

    }



}
