package com.nest.shoppingcart_backend.controller;


import com.nest.shoppingcart_backend.dao.UserLoginDao;

import com.nest.shoppingcart_backend.model.UserLogin;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class UserLoginController {

    private UserLoginDao umdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin",consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserLogin ul){
        System.out.println(ul.getEmail());
        List<UserLogin> result= (List<UserLogin>) umdao.FindUserLogin(ul.getEmail(),ul.getPassword());
        System.out.println(result);
        HashMap<String,String> str=new HashMap<>();
        if(result.size()==0) {
            str.put("status", "failed");
            str.put("message", "user doesn't exist");
        }
        else {
            int id =result.get(0).getId();
            str.put("userId",String.valueOf(id));
            str.put("status", "success");
            str.put("message", "user added successfully");
        }
        return str;
    }





}

