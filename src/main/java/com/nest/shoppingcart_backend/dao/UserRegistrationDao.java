package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.ShoppingCart;
import com.nest.shoppingcart_backend.model.UserRegistration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRegistrationDao extends CrudRepository<UserRegistration, Integer> {

    @Query(value = "SELECT `id`, `address`, `confirmpassword`, `email`, `name`, `password`, `phonenumber`, `username` FROM `userregistration` WHERE  `username` = :username  AND `password` = :password",nativeQuery = true)
    List<UserRegistration> FindUser(@Param("username")String username ,@Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `confirmpassword`, `email`, `name`, `password`, `phonenumber`, `username` FROM `userregistration` WHERE `id` =:id",nativeQuery = true)
    List<UserRegistration> SearchUser(@Param("id")Integer id);



}
