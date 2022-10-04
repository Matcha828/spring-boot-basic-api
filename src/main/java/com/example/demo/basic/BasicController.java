package com.example.demo.basic;

import com.example.demo.model.AppState;
import com.example.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/myBasePath")
public class BasicController {

    @GetMapping("/health")
    public ResponseEntity<?> health(){
        AppState appState = new AppState();
        appState.setStatus("running");
        return ResponseEntity.ok(appState);
    }

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(@RequestParam String firstName,
                                      @RequestParam(required = false) String middleName,
                                      @RequestParam String lastName) {
        User user = new User(firstName, middleName, lastName);
//        User user = new User();
//        user.setFirstName(firstName);
//        user.setMiddleName(middleName);
//        user.setLastName(lastName);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{message}")
    public ResponseEntity<?> pathGreeting(@PathVariable String message){
        return ResponseEntity.ok(message);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(user);
    }
}
