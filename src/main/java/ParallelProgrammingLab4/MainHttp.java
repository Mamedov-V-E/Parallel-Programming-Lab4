package ParallelProgrammingLab4;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.javadsl.Flow;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainHttp {
    private ActorSystem system;

    public MainHttp(ActorSystem system) {
        this.system = system;
    }

    public Flow<HttpRequest, HttpResponse, NotUsed> createRoute(ActorSystem system) {
        
    }
}
