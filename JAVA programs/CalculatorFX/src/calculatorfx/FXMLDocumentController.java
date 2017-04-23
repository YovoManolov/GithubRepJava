/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author yovo
 */
public class FXMLDocumentController implements Initializable {
    Double dataVar ;
    Double result ;
    int operation = 0 ;
    
    @FXML
    private Label label;
    
    @FXML
    private Button nine;

    @FXML
    private Button minus;

    @FXML
    private Button six;

    @FXML
    private Button one;

    @FXML
    private TextField display;

    @FXML
    private Button clear;

    @FXML
    private Button seven;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button division;

    @FXML
    private Button plus;

    @FXML
    private Button eight;

    @FXML
    private Button zero;

    @FXML
    private Button four;

    @FXML
    private Button equals;

    @FXML
    private Button multiplication;

    @FXML
    private Button five;

    @FXML
    void handleButtonAction(ActionEvent event) {
        
         if(event.getSource() == zero){
             display.setText(display.getText() + "0");
         }else if(event.getSource() == one){
             display.setText(display.getText() + "1");
         }else if(event.getSource() == two){
             display.setText(display.getText() + "2");
         }else if(event.getSource() == three){
             display.setText(display.getText() + "3");
         }else if(event.getSource() == four){
             display.setText(display.getText() + "4");
         }else if(event.getSource() == five){
             display.setText(display.getText() + "5");
         }else if(event.getSource() == six){
             display.setText(display.getText() + "6");
         }else if(event.getSource() == seven){
             display.setText(display.getText() + "7");
         }else if(event.getSource() == eight){
             display.setText(display.getText() + "8");  
         }else if(event.getSource() == nine){
             display.setText(display.getText() + "9");
             
         }else if(event.getSource() == clear){
             operation = 0;
             display.setText("");
             result = 0.00;
         }else if(event.getSource() == plus){
             dataVar = 0.00;
             dataVar = Double.parseDouble(display.getText());
             display.setText("");
             operation = 1;
         }else if(event.getSource() == minus){
             dataVar = 0.00;
             dataVar = Double.parseDouble(display.getText());
             display.setText("");
             operation = 2;
         }else if(event.getSource() == division){
             dataVar = 0.00;
             dataVar = Double.parseDouble(display.getText());
             display.setText("");
             operation = 4;
         }else if(event.getSource() == multiplication){
             dataVar = 0.00;
             dataVar = Double.parseDouble(display.getText());
             display.setText("");
             operation = 3;
         }else if(event.getSource() == equals){
             double secondNumber = Double.parseDouble(display.getText());
             switch(operation){
             case 1 :
                 try{
                    result = secondNumber + dataVar ;
                 display.setText(String.valueOf(result));    
                 }catch(ArithmeticException e){
                     e.getStackTrace();
                 } 
                 break;
             case 2 :
                 try{
                 result = dataVar - secondNumber ;
                 display.setText(String.valueOf(result));    
                 }catch(ArithmeticException e){
                     e.getStackTrace();
                 }  
                 
                 break;
             case 3 :
                 try{
                 result = dataVar * secondNumber;
                 display.setText(String.valueOf(result));    
                 }catch(ArithmeticException e){
                     e.getStackTrace();
                 }  
                 break;
             case 4 :
                 try{
                 result = dataVar / secondNumber ;
                 display.setText(String.valueOf(result));    
                 }catch(ArithmeticException e){
                     display.setText("Arithmetic error");
                     e.getStackTrace();
                 }  
                 break;
            }
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
