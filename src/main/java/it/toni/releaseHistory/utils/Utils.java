package it.toni.releaseHistory.utils;

import it.toni.releaseHistory.model.Microservice;
import it.toni.releaseHistory.model.Release;
import it.toni.releaseHistory.model.Step;
import it.toni.releaseHistory.model.Task;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    static String taskName = "SWECMS-4839";
    static String taskDescription = "gestione lingua";

    public static void main(String[] args) {

        System.out.println("Hello, World!");

//        System.out.println(DevFlow.buildStandardDevFlow().toString());

        System.out.println(buildRelease("0.4.0"));

        System.out.println(
                Step.builder().build());
    }

    public static Serializable createMock() {
        return buildRelease("0.4.0");
    }

    public static Release buildRelease(String name) {
        Release r = new Release();
        r.setName(name);
        r.setTasks(buildTasks(taskName, taskDescription));
        return r;
    }

    public Scene buildView() {
        return new Scene(buildReleasePane(), 400, 600);

    }

    private static List<Task> buildTasks(String name, String description) {

        List<Task> tasks = new ArrayList<>();

        Task t1 = new Task();
        t1.setName(name);
        t1.setDescription(description);
        t1.setMicroservices(buildMicroservices());

        tasks.add(t1);

        return tasks;
//        return new ArrayList<>();
    }

    private static List<Microservice> buildMicroservices() {
        List<Microservice> microservices = new ArrayList<>();

        Microservice ms1 = new Microservice();
        ms1.setName("cms-ms-riconoscimenti");
        ms1.setSteps(Step.buildDevFlow());

        microservices.add(ms1);

        return microservices;
    }


    private static TabPane buildReleasePane() {

        List<String> l = List.of("1", "2");
        TabPane tabPane = new TabPane();
//        tabPane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        for (String s : l) {
            Tab tb = new Tab(s, buildReleaseContent(s));
            tb.setClosable(false);
            tabPane.getTabs().add(tb);
        }
//        tabPane.setMinWidth(Region.USE_PREF_SIZE);
//        tabPane.setMinHeight(Region.USE_PREF_SIZE);

        return tabPane;
    }

    private static ScrollPane buildReleaseContent(String s) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        VBox vBox = new VBox();

        List<String> tasks = List.of("t1_" + s, "t2_" + s, "t3_" + s);
        for (String t : tasks) {
            vBox.getChildren().add(buildTaskPane(t));
        }

        scrollPane.setContent(vBox);

        return scrollPane;
    }

    private static TitledPane buildTaskPane(String c) {
        VBox vBox = new VBox();
        List<String> microservices = List.of("m1", "m2", "m3");
        for (String m : microservices) {
            vBox.getChildren().add(buildMicroservicePane(m));
        }

        return new TitledPane(c, vBox);

    }

    private static TitledPane buildMicroservicePane(String m) {
        VBox vBox = new VBox();
        vBox.getChildren().add(buildMicroserviceContent());

        TitledPane tp = new TitledPane(m, vBox);
        tp.setStyle("");
//        tp.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
//        tp.expandedProperty().set(false);
//        tp.prefHeightProperty().set(tp.computeAreaInScreen());
//        tp.prefHeightProperty().set(tp.computeAreaInScreen());
        return tp;
    }

    private static Node buildMicroserviceContent() {

        VBox vBox = new VBox();
        List<String> l = List.of("s1", "s2", "s3");
        for (String s : l) {
            HBox hb = new HBox(25);
            CheckBox c = new CheckBox(s);
            c.setSelected(true);
            hb.getChildren().add(c);
            hb.getChildren().add(new TextField("desc"));
            vBox.getChildren().add(hb);
        }

        return vBox;
    }
}
