package com.unilearntech.unilearntech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class UnilearntechApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnilearntechApplication.class, args);
	}

}
