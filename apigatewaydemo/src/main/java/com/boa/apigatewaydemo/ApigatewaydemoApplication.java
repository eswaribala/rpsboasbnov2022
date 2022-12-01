package com.boa.apigatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;



@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApigatewaydemoApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ApigatewaydemoApplication.class, args);
	}

}
