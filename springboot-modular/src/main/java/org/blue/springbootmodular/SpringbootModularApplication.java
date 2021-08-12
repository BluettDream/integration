package org.blue.springbootmodular;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.blue.springbootmodular.mapper")
public class SpringbootModularApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootModularApplication.class, args);
    }

}
