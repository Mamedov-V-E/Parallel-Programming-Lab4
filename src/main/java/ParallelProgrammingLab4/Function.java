package ParallelProgrammingLab4;

public class Function {
    private final String packageId;
    private final String jsScript;
    private final String functionName;

    public Function(String packageId, String jsScript, String functionName) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
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
