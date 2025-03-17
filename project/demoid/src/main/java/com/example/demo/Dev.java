package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Dev
{

    private int age;

    public Dev()
    {
        System.out.println("dev construct");
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }    
    
    public void build()
    {
        System.out.println("work in 404 bug");
    }



}
