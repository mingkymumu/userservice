package com.noer.userservice.service;

import com.noer.userservice.domain.UserAccount;
import com.noer.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAccount CreateNewUser(UserAccount user)
    {
        return userRepository.save(user);
    }

    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserAccount> getUserById(Long id){
        return userRepository.findById(id);
    }
}
