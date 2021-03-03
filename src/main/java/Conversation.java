import java.io.Serializable;
import java.util.ArrayList;

public class Conversation implements Serializable {
    public ArrayList<Message> messages;

    public Conversation(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
