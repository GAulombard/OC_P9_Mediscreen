package com.openclassrooms.uiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Ui api application.
 */
@SpringBootApplication
@EnableFeignClients("com.openclassrooms.uiapi")
public class UiApiApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(UiApiApplication.class, args);
    }

}
