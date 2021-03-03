import com.google.firebase.database.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private Button button1;
    private Main main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialisation ....");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("messages/mohamed-wafaa");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                ArrayList<Message> messages = new ArrayList<>();

                for( DataSnapshot data : snapshot.child("messages").getChildren()) {
                    System.out.println(data.getValue());
                    Message message = data.getValue(Message.class);
                    messages.add(message);
                }

                messages.forEach(message -> {
                    System.out.println(message.sender + " : " + message.msg + "\n");
                });

            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("The read failed: " + error.getCode());
            }
        });

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onChildRemoved(DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }

    @FXML
    public void handleBtn1(){
        System.out.println("btn clicked");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("messages");

        Message message = new Message("hi", "mohamed");
        ArrayList<Message> messages =  new ArrayList<>();

        messages.add(message);

        Conversation conversation = new Conversation(messages);

        ref.child("mohamed-wafaa").setValueAsync(conversation);
    }


    public void setMain(Main main) {
        this.main = main;
    }
}
