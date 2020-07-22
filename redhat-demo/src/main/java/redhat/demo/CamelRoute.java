package redhat.demo;
import org.apache.camel.builder.RouteBuilder;


public class CamelRoute extends RouteBuilder {
    @Override
    public void configure() {

        rest()
        .post("/sayHello")
            .route()
                .setBody().simple("${body[customer]}")
                .log("${body}")
                .multicast()
                    .to("kafka:kogito_input?brokers=localhost:9092")
                    .to("kafka:displayOutput?brokers=localhost:9092")
                .end()
                
            .endRest()
            ;
        
    }
}