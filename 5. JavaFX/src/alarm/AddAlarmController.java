package alarm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class AddAlarmController implements Initializable {

    @FXML private TextField godzinaTF;
    @FXML private TextField minutyTF;
    
    private ObservableList<String> data;
    private String czas;
    private Clock clock;
    private int godzina;
    private int minuty;
    
    
    @FXML
    private void handleAddButton(){
        if(isValid()){
            setCzas();
            data.add(czas);
            clock.setAlarm(godzina,minuty);
        }
        else
            JOptionPane.showMessageDialog(null, "Nieodpowiednie dane", "Error", JOptionPane.ERROR_MESSAGE);
            
    }
    
    private boolean isValid(){
        try {
            godzina = Integer.parseInt(godzinaTF.getText()); 
            minuty = Integer.parseInt(minutyTF.getText());
            if(((godzina<24)&&(godzina>=0))&&((minuty>=0)&&(minuty<60)))
                return true;
            else return false;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    
    private void setCzas(){
        if(godzina<10&&minuty<10)
                czas ="0"+godzina+":0"+minuty;
            else if(minuty<10){
                czas = godzina+":0"+minuty;
            }
            else if(godzina < 10){
                czas = "0"+godzina+":"+minuty;
            }
            else
            czas = godzina + ":" + minuty;
    }
 

    public void setData(ObservableList<String> data, Clock clock) {
        this.data = data ;
        this.clock = clock;
    }   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
