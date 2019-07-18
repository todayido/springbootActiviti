package com.example.demo.config;

import com.example.demo.model.Person;
import com.example.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HelloService helloService() {
        Person p = new Person();
        return new HelloService();
    }
}
