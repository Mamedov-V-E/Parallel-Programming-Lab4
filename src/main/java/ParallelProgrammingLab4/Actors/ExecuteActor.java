package ParallelProgrammingLab4.Actors;

import ParallelProgrammingLab4.AkkaApp;
import ParallelProgrammingLab4.DataClasses.Function;
import ParallelProgrammingLab4.DataClasses.Result;
import ParallelProgrammingLab4.DataClasses.Test;
import ParallelProgrammingLab4.Messages.ExecuteTestMessage;
import ParallelProgrammingLab4.Messages.StoreMessage;
import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecuteActor extends AbstractActor {


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

                    getContext().actorSelection(AkkaApp.PATH_TO_STORE_ACTOR)
                            .tell(new StoreMessage(func.getPackageId(), new Result(
                                                                                test.getTestName(),
                                                                                test.getExpectedResult(),
                                                                                result,
                                                                                result.equals(test.getExpectedResult()),
                                                                                test.getParams())),
                                    self()
                            );
                }).build();
    }
}
