package ParallelProgrammingLab4;

import ParallelProgrammingLab4.StoreActor.GetMessage;
import ParallelProgrammingLab4.StoreActor.ReturnByKeyMessage;
import ParallelProgrammingLab4.StoreActor.StoreActor;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.javadsl.Flow;
import scala.concurrent.Future;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Pattern;

import static akka.http.javadsl.server.Directives.*;

public class MainHttp {
    private ActorSystem system;

    public MainHttp(ActorSystem system) {
        this.system = system;
    }

    public Route createRoute() {
        return route(
                get(() -> parameter("packageId", packageId -> {
                    Future<Object> result = Patterns.ask(system.actorSelection("store_actor"), new GetMessage(packageId), 10000);
                    return completeOKWithFuture(result, Jackson.marshaller());
                })),
                post(() -> )

        );
    }
}
