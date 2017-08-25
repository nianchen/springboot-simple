package org.jy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class ApplicationController {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationController.class, args);
      /*  ApplicationContext context =  SpringApplication.run(ApplicationController.class, args);
        String[]beanNames = context.getBeanDefinitionNames();
        for(String beanName: beanNames) {
            System.out.println("BeanName: " + beanName);
        }*/
    }

}
