package com.leave.leaveproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = "com.leave.leaveproject")
public class ApplicationConfig extends WebMvcConfigurationSupport {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("swagger-ui.html")
	       .addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
	       .addResourceLocations("classpath:/META-INF/resources/webjars/");
		
	}
	
	@Bean
    public Docket swaggerConfig() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(this.apiDetails())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.leave.leaveproject.restcontrollers"))
                .paths(PathSelectors.ant("/api/*"))
                .build();
        return docket;
    }
	
	public ApiInfo apiDetails()
	{		
		return new ApiInfoBuilder()
				.title("Sample Swagger API Docs")
				.version("1.0.0")
                .description("Sample documentation for Restful API service using swagger api docs. ")
                .license("Apache 2.0")
                .build();
	}
	
	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}
}
