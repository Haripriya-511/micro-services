package com.ecommerce.user;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.h2.tools.Console;
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
//    @PostConstruct
//    public void startH2Console() throws Exception {
//        Console console = new Console();
//        console.runTool("-web",  "-webPort", "9092", "-browser");
//    }
}
