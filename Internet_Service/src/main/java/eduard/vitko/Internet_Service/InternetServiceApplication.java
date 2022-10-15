package eduard.vitko.Internet_Service;

import eduard.vitko.Internet_Service.domain.Role;
import eduard.vitko.Internet_Service.domain.User;
import eduard.vitko.Internet_Service.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class InternetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
