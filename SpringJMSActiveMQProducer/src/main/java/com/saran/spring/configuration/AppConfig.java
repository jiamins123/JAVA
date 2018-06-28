package com.saran.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.saran.spring")
@Import({MessagingConfiguration.class})
public class AppConfig {
	
	 
}
