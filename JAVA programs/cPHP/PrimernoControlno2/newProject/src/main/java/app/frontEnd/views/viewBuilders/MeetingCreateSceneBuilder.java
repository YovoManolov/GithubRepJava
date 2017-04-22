package app.frontEnd.views.viewBuilders;

import app.MainController;
import app.common.constants.PageConstants;
import app.common.exceptions.CreateEventException;
import app.common.models.ViewModels.MeetingView;
import app.common.utilities.DateConverter;
import app.frontEnd.utilities.Validator;
import app.frontEnd.views.viewBuilders.interfaces.SceneBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;


public class MeetingCreateSceneBuilder implements SceneBuilder{
    private MainController controller;

    public MeetingCreateSceneBuilder(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void showScene() {
        BorderPane borderPane = new BorderPane();

        GridPane gridPane = new GridPane();

        Label nameLabel = new Label("Name:");
        Label dateLabel = new Label("Select Date:");
        Label hoursLabel = new Label("Enter hour");
        Label minutesLabel = new Label("Enter minutes");
        Label descriptionLabel = new Label("Enter Description");
        Label selectMarkerLabel = new Label("Select Marker");
        Label selectLocationLabel = new Label("Enter Location");

        gridPane.add(nameLabel, 1, 1);
        gridPane.add(dateLabel, 1, 2);
        gridPane.add(hoursLabel, 1, 3);
        gridPane.add(minutesLabel, 1, 4);
        gridPane.add(descriptionLabel, 1, 5);
        gridPane.add(selectMarkerLabel, 1, 6);
        gridPane.add(selectLocationLabel, 1, 7);


        TextField nameTextField = new TextField();
        DatePicker datePicker = new DatePicker();

        datePicker.setValue(LocalDate.now());
        datePicker.setEditable(false);

        TextField hourTextField = new TextField();
        TextField minutesTextField = new TextField();
        TextArea descriptionText = new TextArea();
        TextField locationText = new TextField();

        ObservableList<String> options = FXCollections.observableArrayList(
                "Private",
                "Confidential",
                "Personal"
        );

        final ComboBox<String> markerComboBox = new ComboBox<>(options);

        gridPane.add(nameTextField, 2, 1);
        gridPane.add(datePicker, 2, 2);
        gridPane.add(hourTextField, 2, 3);
        gridPane.add(minutesTextField, 2,4);
        gridPane.add(descriptionText, 2, 5);
        gridPane.add(markerComboBox, 2, 6);
        gridPane.add(locationText, 2,7);

        borderPane.setLeft(gridPane);

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Close");

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneBuilder mainScene = new MainSceneBuilder(controller);
                mainScene.showScene();
            }
        });

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MeetingView newMeeting = new MeetingView();

                try {
                    newMeeting.setName(nameTextField.getText());
                    newMeeting.setDate(DateConverter.dateToCalendar(DateConverter.LocalDateToDate(datePicker.getValue())));
                    newMeeting.setDescription(descriptionText.getText());
                    newMeeting.setMarker(markerComboBox.getValue());
                    newMeeting.setHour(hourTextField.getText());
                    newMeeting.setMinutes(minutesTextField.getText());
                } catch (CreateEventException ex){
                    controller.showIllegalArgumentsAlert(ex.getMessage());
                    return;
                }
                newMeeting.setType("Task");

                try {
                    Validator.validateEventUniqueness(newMeeting.getName(), controller.getEventService());
                }catch (CreateEventException ex){
                    controller.showIllegalArgumentsAlert(ex.getMessage());
                    return;
                }
                newMeeting.setLocation(locationText.getText());
                newMeeting.setType("Meeting");

                controller.addEvent(newMeeting);
                SceneBuilder sceneBuilder = new MeetingCreateSceneBuilder(controller);
                sceneBuilder.showScene();
            }
        });

        HBox hBox= new HBox(PageConstants.SPACING);

        hBox.getChildren().addAll(okButton, cancelButton);

        borderPane.setBottom(hBox);
        Scene thisScene = new Scene(borderPane, PageConstants.SCREEN_WIDTH, PageConstants.SCREEN_HEIGHT);
        controller.setScene(thisScene, "Create Event");
    }
}
