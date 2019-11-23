package ParallelProgrammingLab4.Actors;

import ParallelProgrammingLab4.AkkaApp;
import ParallelProgrammingLab4.Messages.ExecuteTestMessage;
import ParallelProgrammingLab4.Messages.GetMessage;
import ParallelProgrammingLab4.DataClasses.Test;
import ParallelProgrammingLab4.Messages.TestFunctionMessage;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RouteActor extends AbstractActor {
    private final int EXECUTERS_NUMBER = 5;

    private ActorRef store = getContext().actorOf(
            Props.create(StoreActor.class),
            AkkaApp.STORE_ACTOR_NAME
    );
    private ActorRef executersPool = getContext().actorOf(
            new RoundRobinPool(EXECUTERS_NUMBER)
            .props(Props.create(ExecuteActor.class))
    );

    public Receive createReceive() {
        return receiveBuilder().create()
                .match(TestFunctionMessage.class, m -> {
                    for (Test test : m.getTests()) {
                        executersPool.tell(new ExecuteTestMessage(
                                            m.getFunction(),
                                            test), getSelf());
                    }
                })
                .match(GetMessage.class, m -> {
                    store.forward(m, getContext());
                })
                .build();
    }
}
