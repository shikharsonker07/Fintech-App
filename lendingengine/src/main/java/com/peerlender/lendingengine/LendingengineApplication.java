package com.peerlender.lendingengine;

import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendingengineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LendingengineApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		// save some users

		User user1 = new User(1, "John", "A", 27, "Software Developer");
		User user2 = new User(2, "Peter", "B", 22, "Pilot");
		User user3 = new User(3, "Henry", "C", 21, "Unemployed");

		userRepository.save(user1);
		userRepository.save(user3);
		userRepository.save(user2);
	}

}
