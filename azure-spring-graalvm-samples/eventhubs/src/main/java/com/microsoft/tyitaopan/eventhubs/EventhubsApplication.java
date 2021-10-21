package com.microsoft.tyitaopan.eventhubs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

/**
 * Spring Integration Channel Adapters for Azure Event Hub code sample.
 *
 * @author Warren Zhu
 */
@SpringBootApplication
@EnableIntegration
public class EventhubsApplication{

    public static void main(String[] args) {
        SpringApplication.run(EventhubsApplication.class, args);
    }

}
