package ParallelProgrammingLab4;

import akka.actor.AbstractActor;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecuteActor extends AbstractActor {

    public Receive createReceive() {
        return receiveBuilder().create()
                .match(ExecuteTestMessage.class, m -> {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(m.getFunction().getJsScript());
                    Invocable invocable = (Invocable) engine;
                    return invocable.invokeFunction(m.getFunction().getFunctionName(), m.getTest().getParams()).toString();
                }).build();
    }
}
