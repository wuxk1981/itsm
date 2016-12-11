package com.zdhy.platform.itsm.core.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket testApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.zdhy.platform.itsm.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("IT服务管理接口")
				.termsOfServiceUrl("")
				.contact("吴心宽")
				.version("1.1")
				.build();

		/*
		 * return new ApiInfo("IT服务管理接口",// 大标题 "接口测试",// 小标题 "1.1",// 版本
		 * "NO terms of service", "吴心宽",// 作者 "", "" //
		 * "The Apache License, Version 2.0",//链接显示文字 //
		 * "http://www.apache.org/licenses/LICENSE-2.0.html"//网站链接 );
		 */

	}
}