package com.boa.jwtsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.jwtsecurity.models.User;



public interface UserRepository extends JpaRepository<User,String>{

}
