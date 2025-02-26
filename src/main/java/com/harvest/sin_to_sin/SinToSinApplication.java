package com.harvest.sin_to_sin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harvest.sin_to_sin.service.ApplicationUserService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class SinToSinApplication implements CommandLineRunner{

	private final ApplicationUserService applicationUserService;

	public static void main(String[] args) {
		SpringApplication.run(SinToSinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
