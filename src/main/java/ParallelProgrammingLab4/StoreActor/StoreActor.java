package ParallelProgrammingLab4.StoreActor;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StoreActor extends AbstractActor {
    private Map<String, List<String>> store = new HashMap<>();
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(StoreMessage.class, m -> {
                    Optional<List<String>> optionalList = new Optional<>(store.get(m.getKey()));
                    store.put(m.getKey(), store.gem.getValue());
                    System.out.println("storeActor received message: " + m.toString());
                })
                .match(GetMessage.class, req -> sender().tell(
                        new StoreMessage(req.getKey(), store.get(req.getKey())), self())
                ).build();
    }
}
