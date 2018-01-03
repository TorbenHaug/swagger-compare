package de.haug_dev.swagger_compare.swagger_compare_standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("de.haug_dev")
@EnableWebMvc
@EnableSwagger2
public class SwaggerCompareStandaloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerCompareStandaloneApplication.class, args);
    }
}