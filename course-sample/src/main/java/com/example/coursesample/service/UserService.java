package com.example.coursesample.service;

import com.example.coursesample.model.Supporter;
import com.example.coursesample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Supporter getSupporter(int id){
        return userRepository.getSupporter(id);
    }
}
