package com.rickish.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById(){
        System.out.println("springboot is running ");
        return "Hello ! Springboot is running!";
    }

    @PostMapping
    public  String addInfo(){
        System.out.println("已经新增一个用户");
        return null;
    }
}
