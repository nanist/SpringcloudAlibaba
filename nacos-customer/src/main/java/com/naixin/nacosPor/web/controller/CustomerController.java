package com.naixin.nacosPor.web.controller;

import com.naixin.nacosPor.web.config.HttpUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * rabbitMq 服务消费者
 * Created by liangguannan on 2021/10/26.
 */
@RestController
@RequestMapping("/nacosCustomer")
public class CustomerController {

    /**
     * 使用使用restTemplate方式
     * @return
     */
    @RequestMapping(value = "/getNacosInfo", method = RequestMethod.GET)
    public String getNacosInfo() {
        HttpUtils httpUtils=new HttpUtils();//服务消费者是通过RestTemplate+Ribbon的方式来进行服务调用的。
        return httpUtils.restTemplate().getForObject("http://nacos-provider/nacosProvider/getNacosInfo", String.class);
    }
}
