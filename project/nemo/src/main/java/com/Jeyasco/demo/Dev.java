package com.Jeyasco.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Dev 

{
    @Autowired
    @Qualifier("laptop")
    private computer comp;

    public void build()
    {
        comp.compile();
        System.out.println("work in 404 bug");
    }    

}
