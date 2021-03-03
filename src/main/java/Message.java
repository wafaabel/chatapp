import java.io.Serializable;

public class Message  implements Serializable {
    public String msg;
    public String sender;

    private Message() {}

    public Message(String msg, String sender) {
        this.msg = msg;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
