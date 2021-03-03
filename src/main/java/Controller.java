import com.google.firebase.database.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    final ArrayList<Message> messages;
    final FirebaseDatabase database;

    public Controller() {
        database = FirebaseDatabase.getInstance();
        messages = new ArrayList<>();
    }

    @FXML
    private Button button1;
    private Main main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialisation ....");

        DatabaseReference ref = database.getReference("messages/mohamed-wafaa/messages");

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                System.out.println(snapshot.getValue(Message.class));
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
    public void handleBtn1() {
        System.out.println("btn clicked");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users");

        Map<String, User> users = new HashMap<>();
        users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));
        users.put("gracehop", new User("December 9, 1906", "Grace Hopper"));

        ref.setValueAsync(users);

    }


    public void setMain(Main main) {
        this.main = main;
    }
}
