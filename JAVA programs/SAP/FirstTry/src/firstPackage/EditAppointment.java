/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstPackage;

import firstPackage.Appointment.TypeOfAppointments;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.DefaultListModel;
/**
 *
 * @author yovo
 */
public class EditAppointment extends javax.swing.JFrame {
    Message m = new Message();
    Scanner sc = new Scanner (System.in);
    Appointment beforeOpeningEditBlockAppointment ;
    Appointment afterOpeningEditBlockAppointment ;
    WorkWithHashMap wwhm ;
    DefaultListModel myModel =  new javax.swing.DefaultListModel();
    /**
     * Creates new form EditAppointment
     */
    public EditAppointment(WorkWithHashMap wwhm) {
        this.wwhm = wwhm;
        initComponents();
        initializeFileds();
    }
    private void initializeFileds(){
        DayPlanner dp = new DayPlanner();
        
        boolean isWeeklyListSelected;
        boolean isDailyListSelected;
        isWeeklyListSelected = !dp.weeklyListOfApp.isSelectionEmpty();
        isDailyListSelected = !dp.dailyListOfApp.isSelectionEmpty();
        int index;
        String nameOfAppointment ;
        if(isDailyListSelected){
            dp.dailyListOfApp.setModel(myModel);
            index =  dp.dailyListOfApp.getSelectedIndex();
            nameOfAppointment = (String) myModel.getElementAt(index);
        }
        else if(isWeeklyListSelected){
            dp.weeklyListOfApp.setModel(myModel);
            index =  dp.weeklyListOfApp.getSelectedIndex();
            nameOfAppointment = (String) myModel.getElementAt(index);
        }
        else {
            dp.monthlyListOfApp.setModel(myModel);
            index =  dp.monthlyListOfApp.getSelectedIndex();
            nameOfAppointment = (String) myModel.getElementAt(index);
        }
        
        beforeOpeningEditBlockAppointment = wwhm.searchForElementByName
                                                        (nameOfAppointment);
        nameTextField.setText(beforeOpeningEditBlockAppointment
                                                    .getNameOfAppointment());
        descriptionTextField.setText(beforeOpeningEditBlockAppointment.
                                                        getDescription());
        if(beforeOpeningEditBlockAppointment.getTypeOfAppointment().
                                     equals(TypeOfAppointments.meeting)){
            meetingCheckBox.setSelected(true);
        }else if(beforeOpeningEditBlockAppointment.getTypeOfAppointment().
                                          equals(TypeOfAppointments.task)){
            taskCheckBox.setSelected(true);
        }
    }
 
    private Appointment getElementsOfEditetAppointment() {   
     
        String EdName ;
        String EdDecription ;
        String EdDateOfEditing ;
        TypeOfAppointments EdTypeOfAppointment = null;

        EdName = nameTextField.getText();
        EdDecription = descriptionTextField.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        
        EdDateOfEditing = sdf.format(date);
        if(meetingCheckBox.isSelected())  EdTypeOfAppointment = 
                                            TypeOfAppointments.meeting ;
        if(taskCheckBox.isSelected())  EdTypeOfAppointment = 
                                            TypeOfAppointments.task ;
        
        Appointment editetAppointment = new Appointment(EdName,EdDecription
                ,EdDateOfEditing,EdTypeOfAppointment );
        
        return editetAppointment;
    }
    
    
    private boolean checkIfAppointmentsAreTheSame(){
        /* We must to make sure that changes did happen
         otherwise there is not susbstitution needed 
         */
        boolean equalApp ;
        afterOpeningEditBlockAppointment = getElementsOfEditetAppointment();
        if(  (beforeOpeningEditBlockAppointment.getNameOfAppointment()
         .equals(afterOpeningEditBlockAppointment.getNameOfAppointment()))
          && (beforeOpeningEditBlockAppointment.getDescription()
         .equals(afterOpeningEditBlockAppointment.getDescription()))
          && (beforeOpeningEditBlockAppointment.getDateOfEditing()
         .equals(afterOpeningEditBlockAppointment.getDateOfEditing())) 
          && (beforeOpeningEditBlockAppointment.getTypeOfAppointment()
         .equals(afterOpeningEditBlockAppointment.getTypeOfAppointment()))){
            equalApp = true;
        }else equalApp = false;
        return equalApp;
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        editAppInternalFrame = new javax.swing.JInternalFrame();
        currentAppLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        typeOfAppLabel = new javax.swing.JLabel();
        meetingCheckBox = new javax.swing.JCheckBox();
        taskCheckBox = new javax.swing.JCheckBox();

        jLabel1.setText("jLabel1");

        editAppInternalFrame.setTitle("EditAppointment");
        editAppInternalFrame.setVisible(true);

        currentAppLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentAppLabel.setText("Current Appointment");
        currentAppLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 2, 1, new java.awt.Color(0, 0, 0)));

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name");
        nameLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        nameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLabel.setText("Description");
        descriptionLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        descriptionTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        descriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTextFieldActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        typeOfAppLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typeOfAppLabel.setText("Type of appointment");
        typeOfAppLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        meetingCheckBox.setText("Meeting");
        meetingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetingCheckBoxActionPerformed(evt);
            }
        });

        taskCheckBox.setText("Task");
        taskCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editAppInternalFrameLayout = new javax.swing.GroupLayout(editAppInternalFrame.getContentPane());
        editAppInternalFrame.getContentPane().setLayout(editAppInternalFrameLayout);
        editAppInternalFrameLayout.setHorizontalGroup(
            editAppInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editAppInternalFrameLayout.createSequentialGroup()
                .addGroup(editAppInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(editAppInternalFrameLayout.createSequentialGroup()
                        .addGroup(editAppInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editAppInternalFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editAppInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(currentAppLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeOfAppLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(editAppInternalFrameLayout.createSequentialGroup()
                                .addComponent(meetingCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(taskCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nameTextField))))
                .addContainerGap())
        );
        editAppInternalFrameLayout.setVerticalGroup(
            editAppInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editAppInternalFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editAppInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentAppLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editAppInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editAppInternalFrameLayout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeOfAppLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(editAppInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meetingCheckBox)
                            .addComponent(taskCheckBox)))
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editAppInternalFrame)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editAppInternalFrame)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
        nameTextField.setText(sc.next());
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void descriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextFieldActionPerformed
        // TODO add your handling code here:
        String currentString = null ;
        while(true){
            if(currentString.equals("")){
                descriptionTextField.setText(currentString);
                break;
            }
            currentString += sc.next();
        }
    }//GEN-LAST:event_descriptionTextFieldActionPerformed

    private void meetingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetingCheckBoxActionPerformed
        // TODO add your handling code here:
        if(!beforeOpeningEditBlockAppointment.getTypeOfAppointment().equals("meeting")){
           meetingCheckBox.setSelected(true);
        }
    }//GEN-LAST:event_meetingCheckBoxActionPerformed

    private void taskCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskCheckBoxActionPerformed
        // TODO add your handling code here:
        if(!beforeOpeningEditBlockAppointment.getTypeOfAppointment().equals("task")){
           taskCheckBox.setSelected(true);
        }
    }//GEN-LAST:event_taskCheckBoxActionPerformed

    
    //i check if the Appointment is the same ..
        // if its not the same i will create new
        //Appointment and i will delete the old one 
        //if its the same i will coll setMessage() 
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
       if(!checkIfAppointmentsAreTheSame()){
           m.setMessage("The appointment was not modified");
       }else{
           wwhm.deleteAppointmentFromHashMap(beforeOpeningEditBlockAppointment
                   .getNameOfAppointment());
           wwhm.addAppointmentToHashMap(afterOpeningEditBlockAppointment);
       }
    }//GEN-LAST:event_editButtonActionPerformed

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentAppLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JInternalFrame editAppInternalFrame;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox meetingCheckBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JCheckBox taskCheckBox;
    private javax.swing.JLabel typeOfAppLabel;
    // End of variables declaration//GEN-END:variables
}
