package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Console;

@Configuration
public class BeanConfiguration {

	@Bean
	public Console console() {
		Console bean = new Console();
		return bean;
	}
}
