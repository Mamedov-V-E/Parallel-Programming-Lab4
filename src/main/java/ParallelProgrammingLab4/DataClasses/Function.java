package ParallelProgrammingLab4.DataClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Function {
    private final String packageId;
    private String jsScript;
    private String functionName;

    public Function() {}

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

    public void setJsScript(String jsScript) {
        this.jsScript = jsScript;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
}
