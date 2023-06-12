package com.example.repository;

import com.example.model.Greeting;
import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepository {

    public Greeting getGreeting() {
        return new Greeting("Hello, World!");
    }
}
