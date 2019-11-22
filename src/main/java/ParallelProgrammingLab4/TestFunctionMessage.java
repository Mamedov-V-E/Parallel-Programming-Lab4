package ParallelProgrammingLab4;

public class TestFunctionMessage {
    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;

    public TestFunctionMessage(String packageId, String jsScript, String functionName, Test[] tests) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

}
