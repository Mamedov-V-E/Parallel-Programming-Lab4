package ParallelProgrammingLab4.StoreActor;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.*;

public class StoreActor extends AbstractActor {
    private Map<String, List<String>> store = new HashMap<>();
    private AbstractActor 

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(StoreMessage.class, m -> {
                    Optional<List<String>> optionalList = Optional.ofNullable(store.get(m.getKey()));
                    if (optionalList.isPresent()) {
                        optionalList.get().add(m.getValue());
                    } else {
                        List<String> list = new LinkedList<>();
                        list.add(m.getValue());
                        store.put(m.getKey(), list);
                    }
                    System.out.println("storeActor received message: " + m.toString());
                })
                .match(GetMessage.class, req -> sender().tell(
                        new ReturnMessagesByKey(req.getKey(), store.get(req.getKey())), self())
                ).build();
    }
}
