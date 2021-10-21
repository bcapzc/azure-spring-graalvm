package com.microsoft.tyitaopan.eventhubs;

import com.azure.spring.integration.core.api.reactor.DefaultMessageHandler;
import com.azure.spring.integration.eventhub.api.EventHubOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
// import org.springframework.stereotype.Indexed;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Warren Zhu
 */
// @Indexed
@RestController
@EnableIntegration
public class SendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendController.class);
    static final String OUTPUT_CHANNEL = "output";
    private static final String EVENTHUB_NAME = "pyteventhub";

    @Autowired
    EventHubOutboundGateway messagingGateway;

    /**
     * Posts a message to a Azure Event Hub
     */
    @PostMapping("/messages")
    public String send(@RequestParam("message") String message) {
        this.messagingGateway.send(message);
        return message;
    }

    @Bean
    @ServiceActivator(inputChannel = OUTPUT_CHANNEL)
    public MessageHandler messageSender(EventHubOperation queueOperation) {
        DefaultMessageHandler handler = new DefaultMessageHandler(EVENTHUB_NAME, queueOperation);
        handler.setSendCallback(new ListenableFutureCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                LOGGER.info("Message was sent successfully.");
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("There was an error sending the message.", ex);
            }
        });

        return handler;
    }

}

