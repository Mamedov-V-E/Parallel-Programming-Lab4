package ParallelProgrammingLab4;

public class ExecuteTestMessage {
    private TestFunctionMessage testFunctionMessage;


    public ExecuteTestMessage(TestFunctionMessage testFunctionMessage, String testName, String expectedResult, String params) {
        this.testFunctionMessage = testFunctionMessage;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public TestFunctionMessage getTestFunctionMessage() {
        return testFunctionMessage;
    }

    public void setTestFunctionMessage(TestFunctionMessage testFunctionMessage) {
        this.testFunctionMessage = testFunctionMessage;
    }
}
