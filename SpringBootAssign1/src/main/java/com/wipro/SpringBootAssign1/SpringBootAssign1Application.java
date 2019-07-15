package com.wipro.SpringBootAssign1;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAssign1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssign1Application.class, args);
	}

	 @Bean
	    public CommandLineRunner run(ApplicationContext appContext) {
	        return args -> {

	            String[] beans = appContext.getBeanDefinitionNames();
	            Arrays.stream(beans).sorted().forEach(System.out::println);

	        };
	    }
}
