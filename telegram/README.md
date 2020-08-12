
Go to project
```
oc project demo
```


Create secret

```
oc create secret generic telegram --from-file=telegram.properties
```


Create Channel
```
oc apply -f channel.yaml
oc apply -f channel-reply.yaml
```



Create Channel
```
oc apply -f camelroute.yaml
```

```
kamel run test/CamelTestRoute.java
kamel run TelegramReply.java --secret telegram -d camel-telegram 
```