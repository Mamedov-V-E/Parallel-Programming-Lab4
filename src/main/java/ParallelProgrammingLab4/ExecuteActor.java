package ParallelProgrammingLab4;

import akka.actor.AbstractActor;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public class ExecuteActor extends AbstractActor {

    public Receive createReceive() {
        return receiveBuilder().create()
                .match()
    }
}
