/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstPackage;

/**
 *
 * @author yovo
 */
public class Appointment {
    
    public enum TypeOfAppointments{ meeting,task  } 
    
    private String name;
    private String description ;
    private String dateOfEditing;
    private TypeOfAppointments typeOfAppointment;

  

    public Appointment (String n,String desc,String date,
           TypeOfAppointments typeOfAppointment){
        this.setDescription(desc);
        this.setNameOfAppointment(n);
        this.setDateOfEditing(date);
        this.setTypeOfAppointment(typeOfAppointment);
    }
    
    public TypeOfAppointments convertStringToTypeOfAppointmetns(String type){
        TypeOfAppointments result = null;
        if(type.equals(TypeOfAppointments.meeting.toString()))
            result = TypeOfAppointments.meeting;
        else if(type.equals(TypeOfAppointments.task.toString()))
            result = TypeOfAppointments.task;
        return result;
    }
    
    public TypeOfAppointments getTypeOfAppointment() {
       return typeOfAppointment;
    }
    private void setTypeOfAppointment (TypeOfAppointments typeOfAppointment){
        this.typeOfAppointment = typeOfAppointment;
    }
    
    public String getDateOfEditing() {
        return dateOfEditing;
    }

    private void setDateOfEditing(String date) {
        this.dateOfEditing = date;
    }
  
    public String getNameOfAppointment() {
        return name;
    }

    private void setNameOfAppointment (String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
