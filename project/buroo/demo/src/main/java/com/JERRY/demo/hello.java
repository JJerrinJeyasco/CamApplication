package com.JERRY.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello
{
    @RequestMapping("/")
    public String dam()
    {
        return "hello world,how is everything going";
    }
}