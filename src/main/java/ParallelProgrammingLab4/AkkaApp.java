package ParallelProgrammingLab4;

import ParallelProgrammingLab4.Actors.RouteActor;
import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class AkkaApp {
    public static final String ACTOR_SYSTEM_NAME = "testerSystem";
    public static final String ROUTE_ACTOR_NAME = "routeActor";
    public static final String STORE_ACTOR_NAME = "storeActor";
    public static final String PATH_TO_STORE_ACTOR = "/user/" + AkkaApp.ROUTE_ACTOR_NAME + "/" + AkkaApp.STORE_ACTOR_NAME;
    public static final String PATH_TO_ROUTE_ACTOR = "/user/" + AkkaApp.ROUTE_ACTOR_NAME;
    public static final String HOST_NAME = "localhost";
    public static final int PORT_NUMBER = 8080;

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create(ACTOR_SYSTEM_NAME);
        ActorRef routeActor = system.actorOf(
                Props.create(RouteActor.class),
                ROUTE_ACTOR_NAME
        );

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        MainHttp instance = new MainHttp(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                instance.createRoute().flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost(HOST_NAME, PORT_NUMBER),
                materializer
        );
        System.out.println("Server online at http://" + HOST_NAME + ":" + PORT_NUMBER + "\nPress RETURN to stop...");

        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }
}
