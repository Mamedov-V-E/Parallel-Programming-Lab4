package ParallelProgrammingLab4.DataClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Test {
    private String testName;
    private String expectedResult;
    private Object[] params;

    public Test() {}

    public Test(String testName, String expectedResult, Object[] params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public Object[] getParams() {
        return params;
    }
}
