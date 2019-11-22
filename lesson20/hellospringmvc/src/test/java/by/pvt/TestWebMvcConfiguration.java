package by.pvt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("by.pvt")
public class TestWebMvcConfiguration implements WebMvcConfigurer {

}