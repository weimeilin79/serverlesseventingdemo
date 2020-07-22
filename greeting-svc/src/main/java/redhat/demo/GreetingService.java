package redhat.demo;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.inject.Inject;

import org.kie.kogito.rules.RuleUnit;
import org.kie.kogito.rules.RuleUnitInstance;

import javax.enterprise.context.ApplicationScoped;

/**
 * A bean consuming data from the "input" Kafka topic and applying some conversion.
 * The result is pushed to the "display-console" stream which is an in-memory stream.
 */
@ApplicationScoped
public class GreetingService {

    @Inject
    RuleUnit<GreetingUnit> greetingRuleUnit;

    @Incoming("kogito_input")                                 
    @Outgoing("displayOutput")                         
    @Broadcast                                          
    public String process(String userInput) {
        System.out.println("userInput:["+userInput+"]");

        GreetingUnit greetingUnit = new GreetingUnit();
        RuleUnitInstance<GreetingUnit> greetingSvcInstance = greetingRuleUnit.createInstance(greetingUnit);

        return userInput;
    }

}