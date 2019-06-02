package com.danielme.spring.events;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.danielme.spring.events.services.DemoPublisherService;

@Configuration
@EnableAsync
@ComponentScan(basePackageClasses = EventsApplication.class)
public class EventsApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                EventsApplication.class);
        DemoPublisherService demoPublisherService = applicationContext
                .getBean(DemoPublisherService.class);

        demoPublisherService.doSomething();

        applicationContext.close();
    }

}
