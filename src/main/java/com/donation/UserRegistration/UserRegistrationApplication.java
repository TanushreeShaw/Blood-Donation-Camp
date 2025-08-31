package com.donation.UserRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * Main application class for the User Registration system.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class UserRegistrationApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserRegistrationApplication.class, args);
	}

}
