package ParallelProgrammingLab4;

public class ExecuteTestMessage {
    private final TestFunctionMessage testFunctionMessage;
    private final Test test;

    public ExecuteTestMessage(TestFunctionMessage testFunctionMessage, Test test) {
        this.testFunctionMessage = testFunctionMessage;
        this.test = test;
    }

    public TestFunctionMessage getTestFunctionMessage() {
        return testFunctionMessage;
    }

    public Test getTest() {
        return test;
    }
}
