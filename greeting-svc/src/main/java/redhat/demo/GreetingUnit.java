package redhat.demo;

import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnitData;
import redhat.demo.Greeting;

public class GreetingUnit implements RuleUnitData {

    private  DataStore<Greeting> greetingInput;

    public GreetingUnit(DataStore<Greeting> greetingInput) {
        this.greetingInput = greetingInput;
    } 

    public GreetingUnit() {
        this(DataSource.createStore());
    }

    
    public DataSource<Greeting> getGreetingInput() {
        return greetingInput;
    }
}