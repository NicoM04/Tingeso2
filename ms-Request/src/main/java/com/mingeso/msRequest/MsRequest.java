package com.mingeso.msRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.mingeso.msRequest.Clients")
public class MsRequest {

	public static void main(String[] args) {
		SpringApplication.run(MsRequest.class, args);
	}

}
