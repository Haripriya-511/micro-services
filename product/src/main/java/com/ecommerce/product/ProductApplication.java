package com.ecommerce.product;

import jakarta.annotation.PostConstruct;
//import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
//    @PostConstruct
//    public void startH2Console() throws Exception {
//        Console console = new Console();
//        console.runTool("-web",  "-webPort", "9091", "-browser");
//    }
}
