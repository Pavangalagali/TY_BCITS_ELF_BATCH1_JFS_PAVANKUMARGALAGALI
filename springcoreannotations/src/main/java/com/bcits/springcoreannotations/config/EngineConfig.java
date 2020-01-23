package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.Engine;

@Configuration
public class EngineConfig {
	
	@Bean
	public Engine getEngine() {
		Engine engine = new Engine();
		engine.setCc(800);
		engine.setType("Petrol");
		return engine;
	}
}
