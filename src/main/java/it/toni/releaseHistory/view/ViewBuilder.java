package it.toni.releaseHistory.view;

import it.toni.releaseHistory.model.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.skin.TitledPaneSkin;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ViewBuilder {

    private List<Release> releases;

    public TabPane buildView() {

        TabPane tabPane = new TabPane();

        for (Release r : releases) {
            tabPane.getTabs().add(buildReleaseView(r));
        }
        tabPane.getSelectionModel().selectFirst();
        return tabPane;
    }

    public Tab buildReleaseView(Release release) {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setContent(buildTasksView(release.getTasks()));


        Tab tb = new Tab(release.getName(), scrollPane);
        tb.setClosable(false);
        tb.getStyleClass().add(setBackgroundColor(release));
        return tb;
    }

    public Node buildTasksView(List<Task> tasks) {
        VBox vBox = new VBox();
        for (Task t : tasks) {
            TitledPane tp = new TitledPane("%s - %s".formatted(t.getName(), t.getDescription()), buildMicroservicesView(t.getMicroservices()));
            tp.getStyleClass().add(setBackgroundColor(t));
            vBox.getChildren().add(tp);
        }
        return vBox;
    }

    public VBox buildMicroservicesView(List<Microservice> microservices) {
        VBox vBox = new VBox();
        for (Microservice m : microservices) {
            TitledPane tp = new TitledPane(m.getName(), buildStepsView(m.getSteps()));
            tp.expandedProperty().set(false);
            tp.getStyleClass().add(setBackgroundColor(m));

            vBox.getChildren().add(tp);
        }
        return vBox;
    }

    public VBox buildStepsView(List<Step> steps) {
        VBox vBox = new VBox();
        for (Step s : steps) {
            HBox hb = new HBox(25);
            CheckBox c = new CheckBox(s.getType().name());
            c.setSelected(s.isDone());
            hb.getChildren().add(c);
            hb.getChildren().add(new TextField(s.getNote()));
            vBox.getChildren().add(hb);
        }

        return vBox;
    }

    private String setBackgroundColor(ModelInterface modelInterface){
        if (modelInterface.isDone()) return "done";
        else return "not-done";
    }

}
