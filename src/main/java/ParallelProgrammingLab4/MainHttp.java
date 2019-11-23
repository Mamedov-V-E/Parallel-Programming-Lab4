package ParallelProgrammingLab4;

import ParallelProgrammingLab4.Messages.GetMessage;
import ParallelProgrammingLab4.Messages.TestFunctionMessage;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import scala.concurrent.Future;

import static akka.http.javadsl.server.Directives.*;

public class MainHttp {
    private ActorSystem system;

    public MainHttp(ActorSystem system) {
        this.system = system;
    }

    public Route createRoute() {
        return route(
                get(() ->
                        parameter("packageId", packageId -> {
                            Future<Object> result = Patterns.ask(system.actorSelection("route_actor"), new GetMessage(packageId), 10000);
                            return completeOKWithFuture(result, Jackson.marshaller());
                })),
                post(() ->
                        entity(Jackson.unmarshaller(TestFunctionMessage.class), msg -> {
                            system.actorSelection("route_actor").tell(msg, ActorRef.noSender());
                            return complete("Function test started\n");
                        }))

        );
    }
}
