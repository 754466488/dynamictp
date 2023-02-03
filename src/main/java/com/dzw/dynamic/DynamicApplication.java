package com.dzw.dynamic;

import com.dtp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamicTp
@SpringBootApplication
public class DynamicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicApplication.class, args);
	}

}
