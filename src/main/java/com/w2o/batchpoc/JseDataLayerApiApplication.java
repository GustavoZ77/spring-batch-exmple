package com.amdocs.jceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
public class JseDataLayerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JseDataLayerApiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/Categoria").allowedOrigins("http://localhost:9001","https://jaliscoempleo.herokuapp.com");
				registry.addMapping("/Empleo").allowedOrigins("http://localhost:9001","https://jaliscoempleo.herokuapp.com");
				registry.addMapping("/Empleo/*").allowedOrigins("http://localhost:9001","https://jaliscoempleo.herokuapp.com");
				registry.addMapping("/Skills/*").allowedOrigins("http://localhost:9001","https://jaliscoempleo.herokuapp.com");
				registry.addMapping("/Skill/*").allowedOrigins("http://localhost:9001","https://jaliscoempleo.herokuapp.com");
				registry.addMapping("/Provider/*").allowedOrigins("http://localhost:9001","https://jaliscoempleo.herokuapp.com");
				registry.addMapping("/Provider/skill/*").allowedOrigins("http://localhost:9001","https://jaliscoempleo.herokuapp.com");
				registry.addMapping("/h2-console/*").allowedOrigins("https://jce-api.herokuapp.com/");
			}
		};
	}
}
