package ParallelProgrammingLab4.Actors;

import ParallelProgrammingLab4.Messages.GetMessage;
import ParallelProgrammingLab4.DataClasses.Result;
import ParallelProgrammingLab4.Messages.ReturnByKeyMessage;
import ParallelProgrammingLab4.Messages.StoreMessage;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.*;

public class StoreActor extends AbstractActor {

    private Map<String, List<Result>> store = new HashMap<>();
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(StoreMessage.class, m -> {
                    Optional<List<Result>> optionalList = Optional.ofNullable(store.get(m.getKey()));
                    if (optionalList.isPresent()) {
                        optionalList.get().add(m.getResult());
                    } else {
                        List<Result> list = new LinkedList<>();
                        list.add(m.getResult());
                        store.put(m.getKey(), list);
                    }
                    System.out.println("storeActor received message: " + m.toString());
                })
                .match(GetMessage.class, req -> {
                    Optional<List<Result>> optionalList = Optional.ofNullable(store.get(req.getKey()));
                    if (optionalList.isPresent()) {
                        sender().tell(new ReturnByKeyMessage(req.getKey(), store.get(req.getKey())), self());
                    } else {
                        sender().tell("result not found\n", self());
                    }
                }
                ).build();
    }
}
