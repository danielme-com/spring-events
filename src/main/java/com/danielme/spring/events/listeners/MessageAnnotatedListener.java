package com.danielme.spring.events.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.danielme.spring.events.model.MessageEvent;

@Component
public class MessageAnnotatedListener {

	private static final Logger logger = LoggerFactory.getLogger(MessageAnnotatedListener.class);

	@EventListener
	@Order(1)
	public void listenMessageEvent(MessageEvent event) {
		logger.info("Event received, content = {}, timestamp {}", event.getMessage(), event.getTimestamp());
	}

}