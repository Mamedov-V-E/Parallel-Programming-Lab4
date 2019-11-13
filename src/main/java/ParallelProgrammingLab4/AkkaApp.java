package ParallelProgrammingLab4;

import ParallelProgrammingLab4.StoreActor.StoreActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.stream.ActorMaterializer;

public class AkkaApp {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("testerSystem");
        ActorRef routeActor = system.actorOf(
                Props.create(RouteActor.class)
        );
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        MainHttp instance = new MainHttp(system);
    }
}
