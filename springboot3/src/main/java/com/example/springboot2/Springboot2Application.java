package com.example.springboot2;



import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.springboot2.properties.FileStorageProperties;

@EnableConfigurationProperties({ FileStorageProperties.class})
@SpringBootApplication

public class Springboot2Application  {

	
	public static void main(String[] args) {
		
	
		SpringApplication.run(Springboot2Application.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}


}
