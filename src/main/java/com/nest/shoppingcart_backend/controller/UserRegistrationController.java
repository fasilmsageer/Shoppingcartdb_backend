package com.nest.shoppingcart_backend.controller;



import com.nest.shoppingcart_backend.dao.UserRegistrationDao;
import com.nest.shoppingcart_backend.model.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class UserRegistrationController {

    @Autowired
    private UserRegistrationDao udao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adduser", consumes = "application/json", produces = "application/json")
    public String adduser(@RequestBody UserRegistration u){
        System.out.println(u);
        List<UserRegistration> result = (List<UserRegistration>) udao.FindUser(u.getUsername(),u.getPassword());
        System.out.println(result);
        HashMap<String,String> st = new HashMap<>();
        if(result.size()!=0){
            st.put("status","success");
            st.put("message","user already exist");
        } else{
            udao.save(u);
            st.put("status","success");
            st.put("message","user added successfully");
        }

        return "user added Successfully";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewuser")
    public List<UserRegistration> viewuser(){

        return (List<UserRegistration>) udao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/searchuser", consumes = "application/json", produces = "application/json")
    public List<UserRegistration> searchuser(@RequestBody UserRegistration u){

        return (List<UserRegistration>) udao.SearchUser(u.getId());
    }



}
