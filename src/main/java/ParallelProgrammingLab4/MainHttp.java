package ParallelProgrammingLab4;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.server.Route;
import akka.stream.javadsl.Flow;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static akka.http.javadsl.server.Directives.route;

public class MainHttp {
    private ActorSystem system;

    public MainHttp(ActorSystem system) {
        this.system = system;
    }

    public Route createRoute(ActorSystem system) {
        return route(
                path
        );
    }
}
