package com.henriquephil.menk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MenkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenkApplication.class, args);
	}

	@GetMapping("info")
	public String info() {
		return "Menk Spring";
	}

}
