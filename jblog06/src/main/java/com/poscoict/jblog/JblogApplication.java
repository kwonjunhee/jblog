package com.poscoict.jblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JblogApplication {
	public static void main(String[] args) {
		SpringApplication.run(JblogApplication.class, args); // 트라이캐치는 콘솔용, 웹에선 쓰면 안됨

	}
}
