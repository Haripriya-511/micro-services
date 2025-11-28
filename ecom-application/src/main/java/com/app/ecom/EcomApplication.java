package com.app.ecom;


//import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}
//    @PostConstruct
//    public void startH2Console() throws Exception {
//        Console console = new Console();
//        console.runTool("-web", "-browser", "-tcp");
//    }
}
