package com.danielme.spring.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.danielme.spring.events.services.DemoPublisherService;

@SpringBootApplication
@EnableAsync
public class EventsApplication implements CommandLineRunner{

	@Autowired
	DemoPublisherService service;
	
    public static void main(String[] args) {
    	SpringApplication.run(EventsApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		service.doSomething();
		
	}

}
