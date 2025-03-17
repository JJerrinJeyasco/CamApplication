package com.Jeyasco.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements computer
{
    public void compile()
    {
        System.out.println("code this thing");
    }
}