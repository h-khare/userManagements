package com.users.users.dao;

import com.users.users.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    
    public User findById(int id);

}
