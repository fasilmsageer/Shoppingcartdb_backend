package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.UserRegistration;

import org.springframework.data.repository.CrudRepository;





public interface UserRegistrationDao extends CrudRepository<UserRegistration, Integer> {



}
