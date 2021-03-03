import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {
    public final FirebaseApp app;

    public Main() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("C:\\Users\\user\\Downloads\\chat-12571-firebase-adminsdk-elyzu-d389365f9a.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://chat-12571-default-rtdb.firebaseio.com")
                .build();

        app = FirebaseApp.initializeApp(options);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Controller controller = loader.getController();
        controller.setMain(this);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
