package ParallelProgrammingLab4;

import ParallelProgrammingLab4.StoreActor.StoreMessage;
import akka.actor.AbstractActor;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecuteActor extends AbstractActor {
    private final String PATH_TO_STORE_ACTOR = "/user/" + "routeActor" + "/" + "storeActor";
    public Receive createReceive() {
        return receiveBuilder().create()
                .match(ExecuteTestMessage.class, m -> {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    Function func = m.getFunction();
                    Test test = m.getTest();
                    String result;

                    try {
                        engine.eval(func.getJsScript());
                        Invocable invocable = (Invocable) engine;
                        result = invocable.invokeFunction(func.getFunctionName(), test.getParams()).toString();
                    } catch (Exception e) {
                        result = "ERROR";
                    }

                    getContext().actorSelection(PATH_TO_STORE_ACTOR)
                            .tell(new StoreMessage(func.getPackageId(), new Result(
                                                                                test.getTestName(),
                                                                                test.getExpectedResult(),
                                                                                result,
                                                                                result.equals(test.getExpectedResult()),
                                                                                )));
                }).build();
    }
}
