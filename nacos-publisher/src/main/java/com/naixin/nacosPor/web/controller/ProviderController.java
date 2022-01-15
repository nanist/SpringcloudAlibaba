package com.naixin.nacosPor.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * rabbitMq 服务提供者
 * Created by liangguannan on 2021/10/26.
 */
@RestController
@RequestMapping("/nacosProvider")
public class ProviderController {

    @RequestMapping("/getNacosInfo")
    public String getNacosInfo() {
        for (int i=0;i<50;i++){
            System.out.println("---------------i:"+i);
        }
        return "输出一下：nacos 服务提供者！";
    }


}
