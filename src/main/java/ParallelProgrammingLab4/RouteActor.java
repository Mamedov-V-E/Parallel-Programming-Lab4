package ParallelProgrammingLab4;

import ParallelProgrammingLab4.StoreActor.GetMessage;
import ParallelProgrammingLab4.StoreActor.StoreActor;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RouteActor extends AbstractActor {
    private final int EXECUTERS_NUMBER = 5;

    private ActorRef store = getContext().actorOf(
            Props.create(StoreActor.class)
    );
    private ActorRef executersPool = getContext().actorOf(
            new RoundRobinPool(EXECUTERS_NUMBER)
            .props(Props.create(ExecuteActor.class))
    );

    public Receive createReceive() {
        return receiveBuilder().create()
                .match(TestFunctionMessage.class, m -> {
                    for (Test test : m.getTests()) {
                        executersPool.tell(new ExecuteTestMessage(m.getFunction(),
                                            ));
                    }
                })
                .match(GetMessage.class, m -> {
                    store.forward(m, getContext());
                })
                .build();
    }
}
