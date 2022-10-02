package com.danielme.spring.events.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.danielme.spring.events.model.MessageEvent;

@Service
public class DemoPublisherService {

	private static final Logger logger = LoggerFactory.getLogger(DemoPublisherService.class);

	private final ApplicationEventPublisher publisher;

	public DemoPublisherService(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void doSomething() {
		logger.info("init doSomething method");
		MessageEvent messageEvent = new MessageEvent(this, "Hello!!");
		publisher.publishEvent(messageEvent);
		logger.info("event was published");
	}

}