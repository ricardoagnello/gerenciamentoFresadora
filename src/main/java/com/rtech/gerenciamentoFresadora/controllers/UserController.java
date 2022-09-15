package com.rtech.gerenciamentoFresadora.controllers;

import com.rtech.gerenciamentoFresadora.entities.User;
import com.rtech.gerenciamentoFresadora.exceptionhandler.UserNotFoundException;
import com.rtech.gerenciamentoFresadora.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    //LIST USERS
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    //USER BY ID
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id).orElseThrow(() -> new UserNotFoundException());
    }

    //CREATE USER
    @PostMapping("/users/createUser")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    //UPDATE USER
    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails){
        getUserById(id);
        return userService.updateUser(id, userDetails);
    }



    //DELETE USER
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        getUserById(id);
        userService.deleteUser(id);
    }

}
