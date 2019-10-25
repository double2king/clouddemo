package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceAApplication {
    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class,args);
    }
    //访问其它客户端的http
    @Bean
    @LoadBalanced //通过ribbon实现客户端的负载均衡,也就是由A来决定访问哪个B
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 服务A作为服务消费者通过访问服务B获得的数据转交给前台
     * @return
     */
    @RequestMapping("/proxyHello")
    public String proxyHello(){
        //通过restTemplate对象访问服务B,url中用spring.application.name作为服务请求地址
        String result = restTemplate.getForObject("http://service-b/hello",String.class);
        return result;
    }

}
