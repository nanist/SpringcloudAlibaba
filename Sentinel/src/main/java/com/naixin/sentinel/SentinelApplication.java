package com.naixin.sentinel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@SpringBootApplication
@Slf4j
public class SentinelApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext application = SpringApplication.run(SentinelApplication.class, args);

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

		log.info("╭フ哇、內誰說↘生活萁拾狠简单濄勒今天鹫是明天⊕_⊙");
	}

}
