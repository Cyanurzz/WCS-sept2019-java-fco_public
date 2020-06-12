package com.wildcodeschool.fco.config;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wildcodeschool.fco.Sept2019JavaOrleansFcoApplication;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
	@Value("${app.uploads.dir}")
	private String uploads;
	
	String currentPath = Sept2019JavaOrleansFcoApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	String baseDir = Paths.get(currentPath).getParent().getParent().getParent().toString().replaceFirst("file:", "");

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
        registry
            .addResourceHandler("/uploads/**")
            .addResourceLocations("file:" + baseDir + File.separator + uploads + File.separator);
    }
	
	@Bean("baseDir")
	public String getBaseDir() {
		return baseDir;
	}
	
}

