package risshar;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//To setup the spring Application using Annotation.
@Configuration
//To setup the spring web MVC.
@EnableWebMvc
//To scan all the beans in the same package or children package.
@ComponentScan
public class Application {


}
