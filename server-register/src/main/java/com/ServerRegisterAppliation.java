package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//代表这个应用是eureka服务注册中心
public class ServerRegisterAppliation {
    public static void main(String[] args) {
        SpringApplication.run(ServerRegisterAppliation.class,args);
    }
}
