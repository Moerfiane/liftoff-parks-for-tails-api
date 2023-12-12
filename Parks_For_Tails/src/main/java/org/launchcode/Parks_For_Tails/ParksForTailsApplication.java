package org.launchcode.Parks_For_Tails;

// Importing necessary Spring Boot annotations and classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The @SpringBootApplication annotation is used to mark this class as the starting point of the Spring Boot application.
// It enables auto-configuration, component scanning, and additional configuration capabilities.
@SpringBootApplication
public class ParksForTailsApplication {

	// The main method is the entry point of the application.
	// This is where the Spring Boot application is launched from.
	public static void main(String[] args) {
		// SpringApplication.run() is a static method used to run a Spring Boot application.
		// It sets up the default configuration, starts the Spring application context, and performs the classpath scan.
		// It also starts the embedded Tomcat server by default if spring-boot-starter-web is included in the project.
		SpringApplication.run(ParksForTailsApplication.class, args);
	}

}
