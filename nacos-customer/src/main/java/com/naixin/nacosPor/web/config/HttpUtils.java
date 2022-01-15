package com.naixin.nacosPor.web.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Http请求工具类
 * @author lgn
 * @version 1.0
 * @date 2021/10/26 16:43
 */
public class HttpUtils {
    /**
     * 使用spring框架，可以使用restTemplate来进行http连接请求
     * @return
     */
    @LoadBalanced //负载均衡(该注解标记使用哪种负载均衡策略，服务名访问必须使用)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
