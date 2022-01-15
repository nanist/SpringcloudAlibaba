package com.naixin.nacosPor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * nacos服务消费方
 */
@SpringBootApplication
@EnableDiscoveryClient //@EnableDiscoveryClient都是能够让注册中心能够发现，扫描该该服务。
@Slf4j
@EnableFeignClients("com.naixin.nacosPor.web.service") //添加注解@EnableFeignClients开启OpenFeign 如果不写包名默认找启动类包下面的feignClient
public class NacosCustomerApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext application = SpringApplication.run(NacosCustomerApplication.class, args);

		Environment env = application.getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Login: \thttp://{}:{}/\n\t" +
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"));


		System.out.println("╭フ哇、內誰說↘生活萁拾狠简单濄勒今天鹫是明天⊕_⊙");
	}

}
