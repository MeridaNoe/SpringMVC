package mx.edu.utez.sda.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //String JAVA_home_X = "algo qie no se qescribri";


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/form").setViewName("form");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/g").setViewName("g");
        registry.addViewController("/pg").setViewName("pg");
        registry.addViewController("/pg13").setViewName("pg13");
        registry.addViewController("/nc16").setViewName("nc16");
        registry.addViewController("/18a").setViewName("18a");
        registry.addViewController("/r").setViewName("r");
        registry.addViewController("/e").setViewName("e");
    }
}
