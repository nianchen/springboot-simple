package org.jy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.jy.base.mapper")
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
