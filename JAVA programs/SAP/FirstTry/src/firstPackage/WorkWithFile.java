/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import firstPackage.Appointment.TypeOfAppointments;

/**
 * @author yovo
 */
public class WorkWithFile {

    Document doc;
    private static final String fileName = "Appointments";
    File fileVariable = new File(fileName);
    FileWriter fw;
    XMLOutputter XMLout = new XMLOutputter();
    int counter = 0;
    WorkWithHashMap wwhm;

    public WorkWithFile(WorkWithHashMap wwhm) {
            this.wwhm = wwhm;
    }

    /**
     *
     */
    public void saveAppointmentsInFile() {

        try {
            Element root = new Element("appointments");
            Document doc = new Document(root);

            for (Map.Entry<String, Appointment> me
                    : wwhm.mapOfAppointments.entrySet()) {
                
                Appointment app = me.getValue();
                
                Element node = new Element("apointment-data");
                root.addContent(node);
                
                    Element name = new Element("Name");
                    name.setText(app.getNameOfAppointment());
                    node.addContent(name);

                    Element description = new Element("Description");
                    description.setText(app.getDescription());
                    node.addContent(description);

                    Element dateOfEditing = new Element("DateOfEditing");
                    dateOfEditing.setText(app.getDateOfEditing());
                    node.addContent(dateOfEditing);

                    Element typeOfAppointment = new Element("TypeOfAppointment");
                    typeOfAppointment.setText(app.getTypeOfAppointment().toString());
                    node.addContent(typeOfAppointment);
            }
            fw = new FileWriter(fileVariable);
            XMLout.output(doc, fw);
        } catch (IOException ex) {
            Logger.getLogger(WorkWithFile.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    public void readInfromationFromFile() {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            doc = saxBuilder.build(fileVariable);
            
            Element root = doc.getRootElement();
            List<Element> listOfAppointments = root.getChildren();
            
            for (int i = 0; i < listOfAppointments.size(); i++) {
                Element appointment_data = listOfAppointments.get(i);
                Element name = appointment_data.getChild("Name");
                Element description = appointment_data.getChild("Description");
                Element dateOfEditing = appointment_data.getChild("Date of editing");
                Element typeOfAppointment = appointment_data.getChild("Type of appointment");

                TypeOfAppointments typeOfAppointmentEnum = null;

                if (typeOfAppointment.getText().equals(TypeOfAppointments.meeting.toString())) {
                    typeOfAppointmentEnum = TypeOfAppointments.meeting;
                } else if (typeOfAppointment.getText().equals(Appointment.TypeOfAppointments.task.toString())) {
                    typeOfAppointmentEnum = TypeOfAppointments.task;
                }

                Appointment app = new Appointment(name.getText(), description.getText(),
                        dateOfEditing.getText(), typeOfAppointmentEnum);
                wwhm.addAppointmentToHashMap(app);
            }
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(WorkWithFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    boolean isEmpty() {
        return fileVariable.length() == 0.00;
    }
}
