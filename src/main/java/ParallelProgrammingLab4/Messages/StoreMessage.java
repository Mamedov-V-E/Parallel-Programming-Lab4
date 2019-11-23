package ParallelProgrammingLab4.Messages;

import ParallelProgrammingLab4.DataClasses.Result;

public class StoreMessage {
    private final String key;
    private final Result result;

    public String getKey() {
        return this.key;
    }
    public Result getResult() {
        return this.result;
    }

    public StoreMessage(String key, Result result) {
        this.key = key;
        this.result = result;
    }
}
