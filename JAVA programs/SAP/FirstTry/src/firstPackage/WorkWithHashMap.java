/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;

/**
 *
 * @author yovo
 */
public class WorkWithHashMap {
   Map <String , Appointment > mapOfAppointments;
   Message m ;
   DefaultListModel myModel = new DefaultListModel();
   
    public WorkWithHashMap(){
        mapOfAppointments =  new HashMap <>();
        m = new Message();
    }
   
   public void addAppointmentToHashMap (Appointment app){
       mapOfAppointments.put(app.getNameOfAppointment(),app);
       
        SimpleDateFormat sdf = new SimpleDateFormat("dd/ww/MM/yyyy");
        Date d =  DayPlanner.mainCalendar.getDate();
        String  [] currentDateArray = sdf.format(d).split("/");
      
        String [] appointmentDateArray = app.getDateOfEditing().split("/");
        DayPlanner dp = new DayPlanner();
        
        if(currentDateArray[2].equals(appointmentDateArray[2])){
              dp.monthlyListOfApp.setModel(myModel);
              myModel.addElement(app.getNameOfAppointment());
               if(currentDateArray[1].equals(appointmentDateArray[1])){
                    dp.weeklyListOfApp.setModel(myModel);
                    myModel.addElement(app.getNameOfAppointment());
                   if(currentDateArray[0].equals(appointmentDateArray[0])){
                        dp.dailyListOfApp.setModel(myModel);
                        myModel.addElement(app.getNameOfAppointment());
                   }
               } 
            m.setMessage("New appointment was succesfully added !!! ");  
            m.setVisible(true);
        }
   }

    /**
     *
     * @param nameOfAppointment
     */
    public void deleteAppointmentFromHashMap (String nameOfAppointment){
      for(Map.Entry <String,Appointment> me : mapOfAppointments.entrySet()){
          if(me.getValue().getNameOfAppointment().equals(nameOfAppointment)){
              mapOfAppointments.remove(me.getValue().getNameOfAppointment());
              m.setMessage("The specified appointment"
                      + " was succesfully removed !!!");  
          }
      }
   }
   public Appointment searchForElementByName(String nameOfAppointment){
      Appointment app = null; 
       for(Map.Entry <String,Appointment> me : mapOfAppointments.entrySet()){
          if(me.getValue().getNameOfAppointment().equals(nameOfAppointment)){
            app = mapOfAppointments.get(me.getValue().getNameOfAppointment());
          }else m.setMessage("Appointment not found !!! ");
      }
       return app;  
   }
}
