package com.danielme.spring.events.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextEventsListener {

    private static final Logger logger = LoggerFactory
            .getLogger(ApplicationContextEventsListener.class);

    @EventListener({ ContextStartedEvent.class, ContextRefreshedEvent.class,
            ContextClosedEvent.class, })
    public void processContextStartedEvent() {
        logger.info("any context event received");
    }

}
