package ParallelProgrammingLab4.StoreActor;

import akka.actor.AbstractActor;

import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String, String> store = new HashMap<>();
    @Override
    public Receive createReceive() {

    }
}
