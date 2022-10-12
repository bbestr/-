package com.qinshuihe1;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.SQLOutput;

@SpringBootApplication
@EnableSwagger2
public class CommonApp {
    public static void main(String[] args){
        ConfigurableApplicationContext x1  = SpringApplication.run(CommonApp.class);
        System.out.println("hao");
    }
}
