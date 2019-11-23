package ParallelProgrammingLab4;

import ParallelProgrammingLab4.Result;

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
