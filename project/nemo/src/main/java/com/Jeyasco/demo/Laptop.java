package com.Jeyasco.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop implements computer
{
    @Override
    public void compile()
    {
        System.out.println("fixing 404 error bugs");
    }

}