package ParallelProgrammingLab4.Messages;

public class GetMessage {
    private String key;

    public String getKey() {
        return this.key;
    }
    public GetMessage(String key) {
        this.key = key;
    }
}
