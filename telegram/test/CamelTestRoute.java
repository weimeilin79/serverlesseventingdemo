package test;

import org.apache.camel.builder.RouteBuilder;


public class CamelTestRoute extends RouteBuilder {
    @Override
    public void configure() {

        from("knative:channel/telegram")
            .log("Incoming message from Telegram is ${in.body}")
            .end()
            .to("knative:channel/telegramreply")
        ;
        
    }
}