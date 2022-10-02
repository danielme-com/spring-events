package com.danielme.spring.events.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextEventsListener {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextEventsListener.class);

	@EventListener({ ContextStartedEvent.class, ContextRefreshedEvent.class, ContextStoppedEvent.class, })
	public void listenContextEvents(ApplicationContextEvent event) {
		logger.info("context event received: {}", event.getClass().getSimpleName());
	}

}
