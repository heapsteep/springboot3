package com.heapsteep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Springboot3Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springboot3Application.class, args);
		Client1 client1=context.getBean(Client1.class);
		Interface1 interface1= client1.interface1;
		interface1.getInfo();
	}
}

interface Interface1 {
	void getInfo();
}

@Component
class Implementation1 implements Interface1 {
	@Override
	public void getInfo() {
		System.out.println("------- UserInfo from Implementation 1.");
	}
}

@Component
@Primary
class Implementation2 implements Interface1 {
	@Override
	public void getInfo() {
		System.out.println("******* UserInfo from Implementation 2.");
	}
}

@Component
class Client1{
	@Autowired
	@Qualifier("implementation1")
	Interface1 interface1;
}
