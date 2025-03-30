package it.toni.releaseHistory;

import it.toni.releaseHistory.model.Release;
import it.toni.releaseHistory.service.FileService;
import it.toni.releaseHistory.utils.Utils;
import it.toni.releaseHistory.view.ViewBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static final String filenameJson = "D:\\Workspace\\workspaceSPRING\\ReleaseHistory\\src\\test\\resources\\release_history.json";

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws IOException {

        List<Release> releases = new ArrayList<>();
//        releases.add(Utils.buildRelease("0.4.0"));
//        releases.add(Utils.buildRelease("0.5.0"));
        
        releases = FileService.importJson(filenameJson);

        ViewBuilder viewBuilder = new ViewBuilder(releases);

        Scene scene = new Scene(viewBuilder.buildView(), 400, 600);
        scene.getStylesheets().add("app.css");

        stage.setScene(scene);
        stage.setTitle("Release History");
//        URL url = this.getClass().getResource("app.css");
//        if (url == null) {
//            System.out.println("Resource not found. Aborting.");
//            System.exit(-1);
//        }
        stage.show();

    }

}