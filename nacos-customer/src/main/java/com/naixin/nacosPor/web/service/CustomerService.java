package com.naixin.nacosPor.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lgn
 * @version 1.0
 * @date 2021/10/27 14:14
 */
@FeignClient("nacos-provider")//服务提供者的服务名
public interface CustomerService {

    @GetMapping("nacosProvider/getNacosInfo")//服务提供者的接口名
    String helloNacos();
}
