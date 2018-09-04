package com.example.oauthdemo.repositories;

import com.example.oauthdemo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    public User findUserByUsername(String username);
}
