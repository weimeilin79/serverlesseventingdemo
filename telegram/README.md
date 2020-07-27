
Go to project
```
oc project eventing
```


Create secret

```
oc create secret generic telegram --from-file=telegram.properties
```


Create Channel
```
oc apply -f channel.yaml
```



Create Channel
```
oc apply -f camelroute.yaml
```

```
kamel run test/CamelTestRoute.java --dev 
```