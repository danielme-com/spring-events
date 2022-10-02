package com.danielme.spring.events.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.danielme.spring.events.model.MessageEvent;

@Component
public class MessageAsyncListener {

	private static final Logger logger = LoggerFactory.getLogger(MessageAsyncListener.class);

	@EventListener
	@Async
	public void listenAsyncMessageEvent(MessageEvent event) {
		logger.info("Procesing event asynchronous, content = {} , timestamp {}", event.getMessage(),
				event.getTimestamp());
	}

}