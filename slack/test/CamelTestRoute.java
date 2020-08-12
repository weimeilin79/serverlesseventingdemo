package test;

import org.apache.camel.builder.RouteBuilder;


public class CamelTestRoute extends RouteBuilder {
    @Override
    public void configure() {

        from("knative:channel/slackreply")
            .transform(body().regexReplaceAll("<@UHGQSL4G1>", ""))
            .log("Outgoing to slack : ${body}")
            .to("slack://#camelk?webhookUrl={{slack.webhookUrl}}")
        ;
        
    }
    
}