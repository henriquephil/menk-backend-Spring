package com.henriquephil.menk;

import com.henriquephil.menk.domain.Entidade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/echo")
public class MenkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenkApplication.class, args);
	}

	@PostMapping
	public Entidade get(@RequestBody Entidade echo) {
		return echo;
	}

}
