package com.ecommerce.order;

import jakarta.annotation.PostConstruct;
//import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
//    @PostConstruct
//    public void startH2Console() throws Exception {
//        Console console = new Console();
//        console.runTool("-web",  "-webPort", "9093", "-browser");
//    }
}
