package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Week3Application {

	public static void main(String[] args) {
		SpringApplication.run(Week3Application.class, args);
	}

//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//		JettyEmbeddedServletContainerFactory factory =
//				new JettyEmbeddedServletContainerFactory();
//		return factory;
//	}
}
