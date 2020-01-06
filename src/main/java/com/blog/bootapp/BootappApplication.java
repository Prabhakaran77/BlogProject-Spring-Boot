package com.blog.bootapp;

import com.blog.bootapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class BootappApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(BootappApplication.class);
	public static void main(String[] args)
	{
		SpringApplication.run(BootappApplication.class, args);

		LOGGER.info("Simple log statement");
	}



}
