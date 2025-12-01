package com.demo.configclient;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigclientApplication.class, args);
	}
    @PostConstruct
    public void test() {
        System.out.println("ENV ID = " + System.getenv("ID"));
    }
}
