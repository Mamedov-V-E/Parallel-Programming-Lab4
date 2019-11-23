package ParallelProgrammingLab4.Messages;

import ParallelProgrammingLab4.DataClasses.Function;
import ParallelProgrammingLab4.DataClasses.Test;

public class TestFunctionMessage {
    private final Function function;
    private final Test[] tests;

    public TestFunctionMessage(Function function, Test[] tests) {
        this.function = function;
        this.tests = tests;
    }

    public Function getFunction() {
        return function;
    }

    public Test[] getTests() {
        return tests;
    }
}
