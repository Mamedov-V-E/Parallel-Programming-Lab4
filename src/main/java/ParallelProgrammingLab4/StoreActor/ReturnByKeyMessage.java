package ParallelProgrammingLab4.StoreActor;

import java.util.List;

public class ReturnByKeyMessage {
    private final String key;
    private final String[] messages;

    public String getKey() {
        return this.key;
    }
    public String[] getMessages() {
        return this.messages.clone();
    }

    public ReturnByKeyMessage(String key, List<String> list) {
        this.messages = new String[list.size()];
        list.toArray(messages);
        this.key = key;
    }
}
