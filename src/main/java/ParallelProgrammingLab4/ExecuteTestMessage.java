package ParallelProgrammingLab4;

public class ExecuteTestMessage {
    private TestFunctionMessage testFunctionMessage;
    private String testName;
    private String expectedResult;
    private String params;

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

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

}
