package ParallelProgrammingLab4.Messages;

import ParallelProgrammingLab4.DataClasses.Function;
import ParallelProgrammingLab4.DataClasses.Test;

public class TestFunctionMessage {
    private Function function;
    private Test[] tests;

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
