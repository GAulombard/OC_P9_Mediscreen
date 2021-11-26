package com.openclassrooms.uiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.openclassrooms.uiapi")
public class UiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiApiApplication.class, args);
    }

}
