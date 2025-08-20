package cn.gugufish.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("borrow-service", r -> r
                        .path("/borrow/**")
                        .uri("lb://borrowservice")
                )
                .route("book-service", r -> r
                        .path("/book/**")
                        .uri("lb://bookservice")
                )
                .build();
    }
}