package com.ufpr.pedinte.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/pedinte")
public class PedinteSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedinteSpringApplication.class, args);
    }

}
