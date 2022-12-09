package com.nest.shoppingcart_backend.dao;


import com.nest.shoppingcart_backend.model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserLoginDao extends CrudRepository<UserLogin, Integer> {

        @Query(value = "SELECT `id`, `email`, `password` FROM `userlogin` WHERE  `email` = :email  AND `password` = :password",nativeQuery = true)
        List<UserLogin> FindUserLogin(@Param("email") String email,@Param("password") String password);
}




