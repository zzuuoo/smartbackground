package com.zuo.smartbackground;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zuo.smartbackground.dao")
public class SmartbackgroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartbackgroundApplication.class, args);
	}

}

