import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    public final FirebaseApp app;

    public Main() throws IOException {
        Dotenv dotenv = Dotenv.load();
        System.out.println("GOOGLE_FIREBASE_URL" + dotenv.get("GOOGLE_FIREBASE_URL"));

        FileInputStream serviceAccount =
                new FileInputStream("service-account.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(dotenv.get("GOOGLE_FIREBASE_URL"))
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
