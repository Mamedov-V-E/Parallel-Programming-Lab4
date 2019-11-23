package ParallelProgrammingLab4.Messages;

import ParallelProgrammingLab4.DataClasses.Function;
import ParallelProgrammingLab4.DataClasses.Test;

public class ExecuteTestMessage {
    private final Function function;
    private final Test test;

    public ExecuteTestMessage(Function function, Test test) {
        this.function = function;
        this.test = test;
    }

    public Function getFunction() {
        return function;
    }

    public Test getTest() {
        return test;
    }
}
