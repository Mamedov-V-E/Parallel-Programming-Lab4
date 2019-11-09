package ParallelProgrammingLab4.StoreActor;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String, String> store = new HashMap<>();
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(StoreMessage.class, m -> {
                    store.put(m.getKey(), m.getValue());
                    System.out.println("storeActor received message: " + m.toString());
                })
                .match(GetMessage.class, req -> sender().tell(
                        new StoreMessage(req)
                ))
    }
}
