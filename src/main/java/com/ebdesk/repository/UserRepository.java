package com.ebdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebdesk.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findUserByUsername(String username);

}
