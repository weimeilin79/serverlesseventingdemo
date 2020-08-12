import org.apache.camel.builder.RouteBuilder;

public class CamelBot extends RouteBuilder{


    @Override
    public void configure() {

        from("direct:slackevent")
            .log("Incoming message from slack is ${in.body}")
            .unmarshal().json()
            .choice()
                .when().jsonpath("$.[?(@.challenge)]")
                    .setBody().jsonpath("$.challenge")
                    .log("Received: ${body}")
                .when().jsonpath("$.event[?(@.text)]")
                    .setHeader("username").jsonpath("$.event.user")
                    .setBody().jsonpath("$.event.text")
                    .log("Received: ${body}")
                    .to("knative:channel/slack")
                .otherwise()
                    .log("Received: ${body}")
            .end()
        ;
        
    }
}