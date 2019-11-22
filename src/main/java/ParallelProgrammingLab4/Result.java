package ParallelProgrammingLab4;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect
public class Result {

    @JsonIgnore
    private final String packageId;
    private final String testName;
    private final String expectedResult;
    private final String result;
    private final boolean isSuccessful;
    private final Object[] params;

    public Result(String packageId, String testName, String expectedResult, String result, boolean isSuccessful, Object[] params) {
        this.packageId = packageId;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.result = result;
        this.isSuccessful = isSuccessful;
        this.params = params;
    }

    public String getPackageId() {
        return packageId;
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
