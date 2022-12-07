package com.nest.shoppingcart_backend.controller;

import com.nest.shoppingcart_backend.dao.ShoppingDao;
import com.nest.shoppingcart_backend.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class ShoppingController {

    @Autowired
    private ShoppingDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addproduct", consumes = "application/json", produces = "application/json")
    public String addproduct(@RequestBody ShoppingCart p){
        System.out.println(p.getName().toString());
        dao.save(p);
        return "Product added Successfully";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/searchproduct", consumes = "application/json", produces = "application/json")
    public List<ShoppingCart> SearchEmployee(@RequestBody ShoppingCart e){
        String name = String.valueOf(e.getName()) ;
        System.out.println(name);
        return (List<ShoppingCart>) dao.SearchProduct(e.getName());

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewproduct")
    public List<ShoppingCart> viewproduct(){

        return (List<ShoppingCart>) dao.findAll();
    }
}
