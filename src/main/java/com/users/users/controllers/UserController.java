package com.users.users.controllers;

import java.util.List;
import java.util.Optional;

import com.users.users.entity.User;
import com.users.users.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> list=this.userService.getAllUsers();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        User userCheck=null;
        try {
            userCheck=this.userService.addUser(user);
            return ResponseEntity.of(Optional.of(userCheck));
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") int userId)
    {
        User user=this.userService.getUserById(userId);
        if(user==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user));
    }

    
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> editUser(@RequestBody User user,@PathVariable("userId") int userId)
    {
       try {
           this.userService.editUser(user, userId);
           return ResponseEntity.ok().body(user);
       } catch (Exception e) {
          e.printStackTrace();
       }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable("userId") int userId)
    {
       try {
        this.userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
