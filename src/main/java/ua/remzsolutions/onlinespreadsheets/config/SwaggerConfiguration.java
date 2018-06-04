package ua.remzsolutions.onlinespreadsheets.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {


    @Value("${swagger.api.title}")
    private String apiTitle;

    @Value("${swagger.api.description}")
    private String apiDescription;

    @Value("${swagger.api.version}")
    private String apiVersion;

    @Value("${swagger.api.contact.name}")
    private String contactName;

    @Value("${swagger.api.contact.url}")
    private String contactUrl;

    @Value("${swagger.api.contact.email}")
    private String contactEmail;

    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("epam.com.EPMRDUACMV.controller"))
                .paths(PathSelectors.any())
                .build()
                .enableUrlTemplating(true)
                .ignoredParameterTypes(ApiIgnore.class)
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiTitle)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .description(apiDescription)
                .version(apiVersion)
                .build();
    }

}
