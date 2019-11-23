package ParallelProgrammingLab4;

import ParallelProgrammingLab4.Result;

import java.util.List;

public class ReturnByKeyMessage {
    private final String key;
    private final Result[] results;

    public String getKey() {
        return this.key;
    }
    public Result[] getMessages() {
        return this.results.clone();
    }

    public ReturnByKeyMessage(String key, List<Result> list) {
        this.results = new Result[list.size()];
        list.toArray(results);
        this.key = key;
    }
}
