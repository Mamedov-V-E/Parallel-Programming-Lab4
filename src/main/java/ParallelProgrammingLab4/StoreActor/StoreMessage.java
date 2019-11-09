package ParallelProgrammingLab4.StoreActor;

public class StoreMessage {
    private String key;
    private String value;

    public String getKey() {
        return this.key;
    }
    public String getValue() {
        return this.value;
    }

    public StoreMessage(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.key + this.value;
    }

}
