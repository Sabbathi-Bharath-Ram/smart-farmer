package com.smartfarmer.controller;

import com.smartfarmer.model.User;
import com.smartfarmer.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private final UserRepository repo;
    public AuthController(UserRepository repo) { this.repo = repo; }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,String> body){
        String username = body.get("username");
        String password = body.get("password");
        Optional<User> u = repo.findByUsername(username);
        if(u.isEmpty() || !u.get().getPassword().equals(password)){
            return Map.of("success", false, "message", "Invalid credentials");
        }
        User user = u.get();
        return Map.of("success", true, "user", Map.of("id", user.getId(), "username", user.getUsername(), "fullName", user.getFullName(), "role", user.getRole()));
    }

    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody Map<String,String> body){
        String username = body.get("username");
        if(repo.findByUsername(username).isPresent()){
            return Map.of("success", false, "message", "Username exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(body.get("password"));
        user.setFullName(body.getOrDefault("fullName", username));
        user.setRole(body.getOrDefault("role","FARMER"));
        repo.save(user);
        return Map.of("success", true, "userId", user.getId());
    }
}
