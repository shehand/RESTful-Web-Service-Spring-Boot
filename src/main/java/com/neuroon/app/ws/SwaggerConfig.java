package com.neuroon.app.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	Contact contact = new Contact(
			"Shehan Dhaleesha", 
			"shehan-dhaleesha.ml", 
			"shehandvid@gmail.com");
	
	List<VendorExtension> vendorExtensions = new ArrayList<>();
	
	ApiInfo apiInfo = new ApiInfo(
			"Neuroon Networks RESTful web services documentation",
			"This pages documents Sample app RESTful Web Service endpoints", 
			"1.0.0", 
			"www.neuroonnetworks.lk/terms",
			contact, 
			"MIT", 
			"https://opensource.org/licenses/MIT", 
			vendorExtensions);

	@Bean
	public Docket appDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.protocols(new HashSet<>(Arrays.asList("HTTP","HTTPS")))
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.neuroon.app.ws")).paths(PathSelectors.any()).build();

		return docket;
	}

}
