package ParallelProgrammingLab4;

import ParallelProgrammingLab4.StoreActor.StoreActor;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RouteActor extends AbstractActor {
    private ActorRef store = getContext().actorOf(
            Props.create(StoreActor.class)
    );
    private ActorRef executersPool = getContext().actorOf(
            new RoundRobinPool()
    )
}
