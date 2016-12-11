package com.zdhy.platform.itsm.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@EnableSwagger
public class Swagger1Config {

	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Required to autowire SpringSwaggerConfig
	 */
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	/**
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
	 * framework - allowing for multiple swagger groups i.e. same code base
	 * multiple swagger resource listings.
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
									.apiInfo(apiInfo())
									//.includePatterns(".*?");
									.includePatterns(
											"/business.*",
											//"/catalogue.*",
											//"/homeContent.*",
											"/homeTitle.*",
											""
											);
	}

	private ApiInfo apiInfo() {
		/*
		 * ApiInfo apiInfo = new ApiInfo( "IT服务管理接口", "接口测试",
		 * "My Apps API terms of service", "吴心宽", "My Apps API Licence Type",
		 * "My Apps API License URL"); return apiInfo;
		 */
		return new ApiInfoBuilder().title("IT服务管理接口").termsOfServiceUrl("")
				.contact("吴心宽").description("1.0版本").build();
	}

}