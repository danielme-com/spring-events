package com.danielme.spring.events;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.danielme.spring.events.listeners.MessageAsyncListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.danielme.spring.events.listeners.MessageAnnotatedListener;
import com.danielme.spring.events.listeners.MessageListener;
import com.danielme.spring.events.model.MessageEvent;
import com.danielme.spring.events.services.DemoPublisherService;

@SpringBootTest
class EventsTest {

    @Autowired
    DemoPublisherService publisher;

    @SpyBean
    MessageAnnotatedListener annotatedListener;
    @SpyBean
    MessageListener messageListener;
    @SpyBean
    MessageAsyncListener asyncListener;

    @Test
    void testEventsWereListened() {
        publisher.doSomething();

        verify(annotatedListener, times(1)).listenMessageEvent(any(MessageEvent.class));
        verify(messageListener, times(1)).onApplicationEvent(any(MessageEvent.class));
        verify(asyncListener, timeout(1000).times(1)).listenAsyncMessageEvent(any(MessageEvent.class));
    }

}