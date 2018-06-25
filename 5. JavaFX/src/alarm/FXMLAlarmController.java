package alarm;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class FXMLAlarmController implements Initializable {
    
    @FXML private Canvas canvas;
    @FXML private Pane pane;
    @FXML private ListView<String> alarmList;
    @FXML private Menu menu;
    
    ObservableList<String> observableList = FXCollections.observableArrayList();
    private Clock clock;
    private Label label;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        label = new Label("O autorze");
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showAboutWindow();
        }
        });
        menu.setGraphic(label);
     
        alarmList.setItems(observableList.sorted());
        
        ReadOnlyDoubleProperty widthProperty = pane.widthProperty();
        ReadOnlyDoubleProperty heightProperty = pane.heightProperty();
        canvas.widthProperty().bind(widthProperty);
        canvas.heightProperty().bind(heightProperty);
        clock = new Clock(canvas);
        canvas.widthProperty().addListener(e -> clock.drawClock());
        canvas.heightProperty().addListener(e -> clock.drawClock());

    }    

    @FXML
    private void addAlarm(){
        newAlarm();
    }
    
    @FXML
    private void clearAlarms(){
        observableList.clear();
    }
    
    @FXML
    private void deleteAlarm(){
        int selectedID = alarmList.getSelectionModel().getSelectedIndex();
        int newSelectedID =
            (selectedID == alarmList.getItems().size() - 1)
               ? selectedID - 1
               : selectedID;
 
        observableList.remove(selectedID);
        alarmList.getSelectionModel().select(newSelectedID);
    }
    
    @FXML
    private void handleExitAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    public void showAboutWindow(){
        Stage aboutWindow = new Stage();

        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("About.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(root);
        aboutWindow.setTitle("O autorze");
        aboutWindow.setScene(scene);
        aboutWindow.setResizable(false);
        aboutWindow.initModality(Modality.APPLICATION_MODAL);
        aboutWindow.show();
    }
    
    public void newAlarm() {
        
        Stage newAlarm = new Stage();

        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAlarm.fxml"));
            root = loader.load();
            AddAlarmController controller = loader.getController();
            controller.setData(observableList,clock);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sceneNewAlarm = new Scene(root);

        newAlarm.setTitle("Dodaj alarm");
        newAlarm.setScene(sceneNewAlarm);
        newAlarm.initModality(Modality.APPLICATION_MODAL);
        newAlarm.show();
        
    }
    
}
