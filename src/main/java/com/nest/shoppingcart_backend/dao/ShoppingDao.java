package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.ShoppingCart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingDao extends CrudRepository<ShoppingCart, Integer> {

    @Query(value = "SELECT `id`, `category`, `description`, `name`, `price`, `image` FROM `shoppingcart` WHERE `name` LIKE %:name%",nativeQuery = true)
    List<ShoppingCart> SearchProduct(@Param("name") String name);
}
