package ParallelProgrammingLab4.DataClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect
public class Result {
    private String testName;
    private String expectedResult;
    private String result;
    private boolean isSuccessful;
    private Object[] params;

    public Result() {}

    public Result(String testName, String expectedResult, String result, boolean isSuccessful, Object[] params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.result = result;
        this.isSuccessful = isSuccessful;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getResult() {
        return result;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public Object[] getParams() {
        return params;
    }
}
