package com.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigurationServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(ConfigurationServiceApplication.class);

	@Value("${server.port}")
	private String portno;

	public static void main(String[] args) {
		logger.info("<---------Configuration Service Start------------>");
		SpringApplication.run(ConfigurationServiceApplication.class, args);
		logger.info("<---------Configuration Service End------------>");
	}

	@PostConstruct
	public void init() {
		logger.info("<---------Configuration Service Run On PortNo:------------>" + portno);
	}

}
