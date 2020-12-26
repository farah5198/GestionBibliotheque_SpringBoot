package com.isetN.romans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isetN.romans.entities.Roman;
import com.isetN.romans.service.RomanService;

@SpringBootApplication
public class JpAroman1Application implements CommandLineRunner {
	
	@Autowired
	RomanService romanService;

	public static void main(String[] args) {
		SpringApplication.run(JpAroman1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		romanService.saveRoman(new Roman("Human Right", 2600.0, new Date()));
		romanService.saveRoman(new Roman("sadness", 8800.0, new Date()));
		romanService.saveRoman(new Roman("personnality", 990.0, new Date()));
		
	}

}
