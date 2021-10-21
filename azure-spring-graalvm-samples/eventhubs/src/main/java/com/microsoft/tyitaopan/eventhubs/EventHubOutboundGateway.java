package com.microsoft.tyitaopan.eventhubs;

import org.springframework.integration.annotation.MessagingGateway;
// import org.springframework.messaging.MessageChannel;
// import org.springframework.messaging.MessageHandler;
//
// import static com.microsoft.tyitaopan.eventhubs.SendController.OUTPUT_CHANNEL;

/**
 * Message gateway binding with {@link MessageHandler}
 * via {@link MessageChannel} has name {@value OUTPUT_CHANNEL}
 */
@MessagingGateway(defaultRequestChannel = "output")
public interface EventHubOutboundGateway {
    void send(String text);
}