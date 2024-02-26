package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //get
    @GetMapping("/getuser")
    public ArrayList<UserModel> getUser(){
        return this.userService.getUser();
    }

    //post
    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    // get (id)
    @GetMapping(path = "/{id}") 
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return this.userService.getByid(id);
    }

    // put (id)
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request,@PathVariable Long id){
        return this.userService.updateId(request, id);
    }

    // delete (id)
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean bool = this.userService.deleteUser(id);

        if(bool){
            return " User with id " + id + " delete ";
        }else{
            return "error";
        }
    }

}
