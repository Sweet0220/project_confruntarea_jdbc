package com.mirceanealcos.confruntarea.controller;

import com.mirceanealcos.confruntarea.entity.User;
import com.mirceanealcos.confruntarea.repo.UserRepository;
import com.mirceanealcos.confruntarea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path="/id/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(path="/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping(path="/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>("User created successfully!", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="/delete/all")
    public ResponseEntity<String> deleteAllUsers() {
        try{
            int numRows = userService.deleteUsers();
            return new ResponseEntity<>("Deleted " + numRows + " user(s) successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete users!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        try{
            userService.deleteById(id);
            return new ResponseEntity<>("User with id "+id+" deleted successfully!",HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Error..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody User user) {
        if(userService.updateUser(id,user))
            return new ResponseEntity<>("User updated successfully!", HttpStatus.OK);
        return new ResponseEntity<>("Error..", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
