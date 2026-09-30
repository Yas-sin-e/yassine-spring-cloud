package com.yassine.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }
//    @Bean
//    public RouteLocator customRouteConfig(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("grade-route", p -> p
//                        .path("/api/Grade/**")
//                        .uri("lb://GRADE")) //lb c'est a dire load balancing
//                .route("employee-route", p -> p
//                        .path("/api/employes/**")
//                        .uri("lb://EMPLOYEE"))
//                .build();
//    }
}
