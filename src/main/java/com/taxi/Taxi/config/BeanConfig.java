package com.taxi.Taxi.config;

import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class BeanConfig {
	@Bean
	MavenXpp3Reader getMavenXppReader() {
		return new MavenXpp3Reader();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}


}
