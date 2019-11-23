package ParallelProgrammingLab4.Actors;

import ParallelProgrammingLab4.Messages.GetMessage;
import ParallelProgrammingLab4.DataClasses.Result;
import ParallelProgrammingLab4.Messages.ReturnByKeyMessage;
import ParallelProgrammingLab4.Messages.StoreMessage;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.*;

public class StoreActor extends AbstractActor {
    private static final String NOT_FOUND_MESSAGE = "result not found\n";

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
                    System.out.println("StoreMessage request for test named \"" + m.getResult().getTestName() + "\"recived by storeActor");
                })
                .match(GetMessage.class, req -> {
                    System.out.println("GetMessage request recived by storeActor");
                    Optional<List<Result>> optionalList = Optional.ofNullable(store.get(req.getKey()));
                    if (optionalList.isPresent()) {
                        sender().tell(new ReturnByKeyMessage(req.getKey(), store.get(req.getKey())), self());
                    } else {
                        sender().tell(NOT_FOUND_MESSAGE, self());
                    }
                }
                ).build();
    }
}
