package com.users.users.services;

import java.util.List;

import com.users.users.dao.UserRepository;
import com.users.users.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        List<User> list=(List<User>)this.userRepository.findAll();
        return list;
    }

    public User getUserById(int userId)
    {
        User user=null;
        try {
            user=this.userRepository.findById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public User addUser(User user)
    {
        try {
            this.userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User editUser(User user,int userId)
    {
        User us=null;

     try {
        user.setId(userId);
        this.userRepository.save(user);
        us=this.userRepository.findById(userId);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return us;
    }

    public void deleteUserById(int userId)
    {
        this.userRepository.deleteById(userId);
    }
    
}
