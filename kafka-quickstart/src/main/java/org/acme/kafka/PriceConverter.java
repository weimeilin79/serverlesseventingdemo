package org.acme.kafka;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

/**
 * A bean consuming data from the "input" Kafka topic and applying some conversion.
 * The result is pushed to the "display-console" stream which is an in-memory stream.
 */
@ApplicationScoped
public class PriceConverter {

    
    @Incoming("displayOutput")                                 
    @Outgoing("display-console")                         
    @Broadcast                                          
    public String process(String userInput) {
        System.out.println("userInput:["+userInput+"]");
        return userInput;
    }

}