package com.naixin.Gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * gateway 配置路由第二种方式 代码
 * @author lgn
 * @version 1.0
 * @date 2021/12/21 11:43
 */
@Configuration
public class GateWayConfig {

    /**
     * 代码中注入 RouteLocator 的Bean
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes =routeLocatorBuilder.routes();
        routes.route("path_route",r ->
                r.path("/guonei")
                        .uri("https://news.baidu.com/guonei"));
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes =routeLocatorBuilder.routes();
        routes.route("path_route",r ->
                r.path("/guoji")
                        .uri("https://news.baidu.com/guoji"));
        return routes.build();
    }
}
