
Go to project
```
oc project demo
```

Create an app - in `https://api.slack.com/`

Get the Bot token from the *OAuth Tokens for Your Team*

https://api.slack.com/apps/AHSL35GF9/install-on-team


Set permissions for our bot.
https://api.slack.com/apps/AHSL35GF9/oauth?

In Bot Token Scopes
Make sure you have : 
 - app_mentions:read
 - channels:read
 - chat:write
 - channels:history


Create secret

```
oc create secret generic slack --from-file=slack.properties
```

Create Channel

```
oc apply -f channel.yaml
oc apply -f channel-reply.yaml
```


Start up the Camel Bot Listener 

```
kamel run --open-api SlackCamelBot.yaml -p slack.properties CamelBot.java
```

Enable the event subscription
https://api.slack.com/apps/AHSL35GF9/event-subscriptions?

Subscribe to bot events
    - app_mentions


kamel run test/CamelTestRoute.java --secret slack





Create Channel
```
oc apply -f camelroute.yaml
```

```
kamel run test/CamelTestRoute.java --dev 
```