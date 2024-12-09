package com.mingeso.msRegister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsRegister {

	public static void main(String[] args) {
		SpringApplication.run(MsRegister.class, args);
	}

}
