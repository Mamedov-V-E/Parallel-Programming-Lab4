package ParallelProgrammingLab4.StoreActor;

import java.util.List;

public class ReturnMessagesByKey {
    private final String key;
    private final String[] messages;

    public String getKey() {
        return this.key;
    }
    public String[] getMessages() {
        return this.messages.clone();
    }

    public ReturnMessagesByKey(String key, List<String> list) {
        this.messages = new String[list.size()];
        list.toArray(messages);
        this.key = key;
    }
}
