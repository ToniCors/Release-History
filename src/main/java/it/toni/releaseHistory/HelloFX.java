package it.toni.releaseHistory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class HelloFX extends Application {

//    @Override
//    public void start(Stage stage) {
//        Label l = new Label("Hello, JavaFX  running on Java .");
//        Scene scene = new Scene(new StackPane(l), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override
    public void start(Stage stage) throws Exception {
        //        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

//        getClass().getResource("BasicFXML.fxml").getPath()
        File f = new File("C:\\Toni\\WorkSpace\\Tools\\ReleaseHistory\\BasicFXML.fxml");
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BasicFXML.fxml")));
        Parent root = FXMLLoader.load(f.toURL());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}