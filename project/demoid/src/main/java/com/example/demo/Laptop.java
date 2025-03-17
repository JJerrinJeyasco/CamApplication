package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop 
{
    public Laptop()
    {
        System.out.println("laptop construct");
    }
    public void compile()
    {
    
        System.out.println("compiling in 404 bug");
    }        
}
