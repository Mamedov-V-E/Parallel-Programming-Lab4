package ParallelProgrammingLab4;

import ParallelProgrammingLab4.StoreActor.StoreActor;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class RouteActor extends AbstractActor {
    private ActorRef store = getContext().actorOf(
            Props.create(StoreActor.class)
    );
    private ActorRef 
}
