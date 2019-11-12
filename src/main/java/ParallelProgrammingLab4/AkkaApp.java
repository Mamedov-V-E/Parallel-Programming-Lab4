package ParallelProgrammingLab4;

import ParallelProgrammingLab4.StoreActor.StoreActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaApp {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("testerSystem");
        ActorRef routeActor = system.actorOf(
                Props.create(RouteActor.class)
        );
    }
}
