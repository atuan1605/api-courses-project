package com.example.coursesample.controller;

import com.example.coursesample.model.Supporter;
import com.example.coursesample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SupporterController {
    @Autowired
    private UserService userService;
    @GetMapping("/supporter")
    public Supporter getSupporter(@RequestParam int id){
         return userService.getSupporter(id);
    }
}
