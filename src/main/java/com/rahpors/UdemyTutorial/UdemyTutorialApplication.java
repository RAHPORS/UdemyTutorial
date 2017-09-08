package com.rahpors.UdemyTutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UdemyTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyTutorialApplication.class, args);
	}
}
