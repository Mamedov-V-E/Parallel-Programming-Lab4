package ParallelProgrammingLab4;

public class TestFunctionMessage {
    private String packageId;
    private String jsScript;
    private String functionName;
    private String[] tests;

    public TestFunctionMessage(String packageId, String jsScript, String functionName, String[] tests) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

}
