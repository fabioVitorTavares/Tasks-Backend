package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		System.out.println('Ola mndo');
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Get() {
		return "Hello java world!";
	}
}
