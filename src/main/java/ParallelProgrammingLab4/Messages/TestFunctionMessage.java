package ParallelProgrammingLab4.Messages;

import ParallelProgrammingLab4.DataClasses.Function;
import ParallelProgrammingLab4.DataClasses.Test;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class TestFunctionMessage {
    private Function function;
    private Test[] tests;

    public TestFunctionMessage() {}

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
