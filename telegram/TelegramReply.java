

import org.apache.camel.builder.RouteBuilder;


public class TelegramReply extends RouteBuilder {
    @Override
    public void configure() {

        from("knative:channel/telegramreply")
            .log("Incoming message from Telegram is ${in.body}")
            .unmarshal().json()
            .setHeader("CamelTelegramChatId").jsonpath("$.chat.id")
            .setBody().jsonpath("$.text")
            .log("chatid :[${headers.CamelTelegramChatId}] ${body}")
            .end()
            .to("telegram://bots?authorizationToken={{telegram.token}}&chatId=${headers.CamelTelegramChatId}")
        ;
        
    }
}