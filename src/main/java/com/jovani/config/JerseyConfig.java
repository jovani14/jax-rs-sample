package com.jovani.config;

import javax.ws.rs.ApplicationPath;

import com.jovani.resource.HelloWorldResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import io.swagger.jaxrs.config.BeanConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	/**
	 * In constructor we can define Jersey Resources & Other Components
	 */
	public JerseyConfig() {
		
		/*
		 * Jersey will automatically register class with @provider, @Component  by scanning
		 * these packages + nested packages
		 */
		packages("com.jovani.resource");
		
		/* CustomTypeParamterConsumeResource auto scanned and register */
		//register(CustomTypeParamterConsumeResource.class);
		register(HelloWorldResource.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
		register(MultiPartFeature.class);

		// Swagger
		register(io.swagger.jaxrs.listing.ApiListingResource.class);
		register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("2");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("com.jovani.resource");
		beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);

		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}