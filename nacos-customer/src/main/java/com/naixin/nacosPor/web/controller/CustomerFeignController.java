package com.naixin.nacosPor.web.controller;

import com.naixin.nacosPor.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgn
 * @version 1.0
 * @date 2021/10/27 14:32
 */
@RestController
@RequestMapping("/nacosCustomer")
public class CustomerFeignController {

    @Autowired
    private CustomerService customerService;

    /**
     * 使用使用FeignClient方式
     * @return
     */
    @GetMapping("/feign")
    public String feignTest() {
        return customerService.helloNacos();
    }
}
