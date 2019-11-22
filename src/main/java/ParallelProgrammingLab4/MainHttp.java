package ParallelProgrammingLab4;

import akka.actor.ActorSystem;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainHttp {
    private ActorSystem system;

    public MainHttp(ActorSystem system) {
        this.system = system;
    }

    public Flow<HttpRequest, HttpResponsecreateRoute
}
