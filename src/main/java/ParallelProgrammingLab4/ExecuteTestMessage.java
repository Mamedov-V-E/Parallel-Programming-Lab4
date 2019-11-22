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

    public void setTestFunctionMessage(TestFunctionMessage testFunctionMessage) {
        this.testFunctionMessage = testFunctionMessage;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
