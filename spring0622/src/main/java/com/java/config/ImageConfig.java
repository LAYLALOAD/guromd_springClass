package com.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//이미지를 다운받는 위치 설정
@Configuration
public class ImageConfig implements WebMvcConfigurer {
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) { //ResourceHandler: url을 ResourceHandler으로 집중
		registry.addResourceHandler("/images/**") //**:모든 디렉토리, 모든 파일
		.addResourceLocations("file:///c:/upload/");
		
	}

}
