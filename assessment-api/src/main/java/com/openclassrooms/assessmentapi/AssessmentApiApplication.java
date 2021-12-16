package com.openclassrooms.assessmentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Assessment api application.
 */
@SpringBootApplication
@EnableFeignClients("com.openclassrooms.assessmentapi")
public class AssessmentApiApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AssessmentApiApplication.class, args);
    }

}
