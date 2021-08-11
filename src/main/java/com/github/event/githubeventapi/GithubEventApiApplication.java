package com.github.event.githubeventapi;

import com.github.event.controller.EventController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.github.event.service","com.github.event.controller"})
public class GithubEventApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubEventApiApplication.class, args);
    }

}
