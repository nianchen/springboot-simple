package org.jy.base.config;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements EnvironmentAware {
    public static final String DEFAULT_INCLUDE_PATTERN = "/.*";
    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(final Environment environment) {
        propertyResolver = new RelaxedPropertyResolver(environment, "swagger.");
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metaData())
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                /*.apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))*/
                .paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
                .build();
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .version("1.0")
                .contact(new Contact("vvWang-java", "http://www.1dianxueche.com", "454255310@qq.com"))
                .description("Spring Boot REST API for Online Store")
                .termsOfServiceUrl("Terms of service")
                .build();
    }
}
