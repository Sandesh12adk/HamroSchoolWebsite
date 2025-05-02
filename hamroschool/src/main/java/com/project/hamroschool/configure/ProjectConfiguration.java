package com.project.hamroschool.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectConfiguration implements WebMvcConfigurer {
 @Override
   public void addViewControllers(ViewControllerRegistry registry){
     registry.addViewController("/courses").setViewName("courses");  // the second one is the name of the html file
       registry.addViewController("/about").setViewName("about");
       registry.addViewController("/home").setViewName("home");
     registry.addViewController("/dashboard").setViewName("dashboard");  //Login success
     registry.addViewController("/demo").setViewName("demo");
  }
}