package com.nest.shoppingcart_backend.controller;



import com.nest.shoppingcart_backend.dao.UserRegistrationDao;
import com.nest.shoppingcart_backend.model.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserRegistrationController {

    @Autowired
    private UserRegistrationDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adduser", consumes = "application/json", produces = "application/json")
    public String adduser(@RequestBody UserRegistration u){
        System.out.println(u.getName().toString());
        dao.save(u);
        return "user added Successfully";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewuser")
    public List<UserRegistration> viewuser(){

        return (List<UserRegistration>) dao.findAll();
    }



}
