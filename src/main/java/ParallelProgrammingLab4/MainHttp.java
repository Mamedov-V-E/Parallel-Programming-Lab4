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
    private static final String PACKAGE_ID_PARAM_NAME = "packageId";
    private static final String PATH_TO_ROUTE_ACTOR = "/user/" + AkkaApp.ROUTE_ACTOR_NAME;

    private ActorSystem system;

    public MainHttp(ActorSystem system) {
        this.system = system;
    }

    public Route createRoute() {
        return route(
                path()
                path("results", () -> {
                    get(() ->
                            parameter(PACKAGE_ID_PARAM_NAME, packageId -> {
                                Future<Object> result = Patterns.ask(system.actorSelection(PATH_TO_ROUTE_ACTOR), new GetMessage(packageId), 10000);
                                return completeOKWithFuture(result, Jackson.marshaller());
                            }));
                }),
                post(() ->
                        entity(Jackson.unmarshaller(TestFunctionMessage.class), msg -> {
                            system.actorSelection(PATH_TO_ROUTE_ACTOR).tell(msg, ActorRef.noSender());
                            return complete("Function test started\n");
                        }))

        );
    }
}
