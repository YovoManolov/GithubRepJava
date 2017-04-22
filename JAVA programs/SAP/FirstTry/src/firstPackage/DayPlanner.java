/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstPackage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;


/**
 * @author yovo
 */
public class DayPlanner extends javax.swing.JFrame {

    public javax.swing.DefaultListModel myModel;
    public WorkWithHashMap wwhm = new WorkWithHashMap();
    public WorkWithFile wwf = new WorkWithFile(wwhm);
    Message m = new Message();
    int index;
    /**
     * Creates new form DayPlanner
     */
    public DayPlanner() {
        initComponents();
        
        myModel = new javax.swing.DefaultListModel();
        get_setAppButton.setEnabled(false);
        setDate();
        
        DateChooser.getDateEditor().
                addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                   get_setAppButton.setEnabled(true);
                }
        }); 
        
        
        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent event) {
            exitProcedure();
        }
    });
    }
    
    public void exitProcedure() {
        wwf.saveAppointmentsInFile();
        clearListsOfDayPlanner();
        System.exit(0);
    }

    public void setDate(){
        ActionListener actionDate = new ActionListener (){  
            @Override
            public void actionPerformed(ActionEvent e) {
            //To change body of generated methods, choose Tools | Templates.
                SimpleDateFormat sdf = new SimpleDateFormat("dd/ww/MM/yyyy");
                Date date = new Date();
                CurrentDateLabel.setText(sdf.format(date));
            }
        };
        Timer t = new Timer(1000,actionDate);
        t.start();
    }
    
    public void clearListsOfDayPlanner() {
       this.monthlyListOfApp.removeAll();
       this.weeklyListOfApp.removeAll();
       this.dailyListOfApp.removeAll();
       m.setMessage("Lists are clear");
    }
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        dailyPlannerInternalFrame = new javax.swing.JInternalFrame();
        get_setAppButton = new javax.swing.JButton();
        halloLabel = new javax.swing.JLabel();
        appointmentsPannel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dAppLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dailyListOfApp = new javax.swing.JList<>();
        dailyAddButton = new javax.swing.JButton();
        dailyEditButton = new javax.swing.JButton();
        dailyDeleteButton = new javax.swing.JButton();
        dDescriptionTextField = new javax.swing.JTextField();
        dailyDescriptionLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        wAppLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        weeklyListOfApp = new javax.swing.JList<>();
        weeklyAddButton = new javax.swing.JButton();
        weeklyEditButton = new javax.swing.JButton();
        weeklyDeleteButton = new javax.swing.JButton();
        wDescriptionTextField = new javax.swing.JTextField();
        weeklyDescriptionLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        mAppLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        monthlyListOfApp = new javax.swing.JList<>();
        monthlyAddButton = new javax.swing.JButton();
        monthlyEditButton = new javax.swing.JButton();
        monthlyDeleteButton = new javax.swing.JButton();
        mDescriptionTextField = new javax.swing.JTextField();
        monthlyDescriptionLabel = new javax.swing.JLabel();
        mainCalendar = new com.toedter.calendar.JCalendar();
        CurrentDateLabel = new javax.swing.JLabel();
        choseDateLabel = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dailyPlannerInternalFrame.setClosable(true);
        dailyPlannerInternalFrame.setIconifiable(true);
        dailyPlannerInternalFrame.setMaximizable(true);
        dailyPlannerInternalFrame.setResizable(true);
        dailyPlannerInternalFrame.setTitle("DailyPlanner");
        dailyPlannerInternalFrame.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dailyPlannerInternalFrame.setVisible(true);
        dailyPlannerInternalFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                dailyPlannerInternalFrameAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        get_setAppButton.setText("Get appointments / Set Appointments for chosen date");
        get_setAppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_setAppButtonActionPerformed(evt);
            }
        });

        halloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        halloLabel.setText("Hallo from your DayPlanner");

        dAppLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dAppLabel.setText(" Appointments");
        dAppLabel.setToolTipText("");

        jScrollPane2.setViewportView(dailyListOfApp);

        dailyAddButton.setText("Add");
        dailyAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyAddButtonActionPerformed(evt);
            }
        });

        dailyEditButton.setText("Edit");
        dailyEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyEditButtonActionPerformed(evt);
            }
        });

        dailyDeleteButton.setText("Delete");
        dailyDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyDeleteButtonActionPerformed(evt);
            }
        });

        dailyDescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dailyDescriptionLabel.setText("Description ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dAppLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dailyEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dailyAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dailyDeleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dDescriptionTextField)
                            .addComponent(dailyDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(dAppLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dailyAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dailyEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dailyDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dailyDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        appointmentsPannel.addTab("dailyAppointments", jPanel1);

        wAppLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wAppLabel.setText(" Appointments");
        wAppLabel.setToolTipText("");

        weeklyListOfApp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "first app", "secind app", "so on ..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(weeklyListOfApp);

        weeklyAddButton.setText("Add");
        weeklyAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyAddButtonActionPerformed(evt);
            }
        });

        weeklyEditButton.setText("Edit");
        weeklyEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyEditButtonActionPerformed(evt);
            }
        });

        weeklyDeleteButton.setText("Delete");
        weeklyDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyDeleteButtonActionPerformed(evt);
            }
        });

        weeklyDescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weeklyDescriptionLabel.setText("Description ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wAppLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weeklyAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(weeklyEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(weeklyDeleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wDescriptionTextField)
                            .addComponent(weeklyDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(wAppLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(weeklyAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weeklyEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weeklyDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(weeklyDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        appointmentsPannel.addTab("weeklyAppointments", jPanel2);

        mAppLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mAppLabel.setText(" Appointments");
        mAppLabel.setToolTipText("");

        monthlyListOfApp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "first app", "secind app", "so on ..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(monthlyListOfApp);

        monthlyAddButton.setText("Add");
        monthlyAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyAddButtonActionPerformed(evt);
            }
        });

        monthlyEditButton.setText("Edit");
        monthlyEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyEditButtonActionPerformed(evt);
            }
        });

        monthlyDeleteButton.setText("Delete");
        monthlyDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyDeleteButtonActionPerformed(evt);
            }
        });

        monthlyDescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthlyDescriptionLabel.setText("Description ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mAppLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(monthlyEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(monthlyAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(monthlyDeleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mDescriptionTextField)
                            .addComponent(monthlyDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(mAppLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(monthlyDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(monthlyAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(monthlyEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(monthlyDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        appointmentsPannel.addTab("monthlyAppointments", jPanel3);
        appointmentsPannel.addTab("Calendar", mainCalendar);

        CurrentDateLabel.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        choseDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choseDateLabel.setText("Please chose a day to continue : ");

        javax.swing.GroupLayout dailyPlannerInternalFrameLayout = new javax.swing.GroupLayout(dailyPlannerInternalFrame.getContentPane());
        dailyPlannerInternalFrame.getContentPane().setLayout(dailyPlannerInternalFrameLayout);
        dailyPlannerInternalFrameLayout.setHorizontalGroup(
            dailyPlannerInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dailyPlannerInternalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dailyPlannerInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(get_setAppButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dailyPlannerInternalFrameLayout.createSequentialGroup()
                        .addGroup(dailyPlannerInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dailyPlannerInternalFrameLayout.createSequentialGroup()
                                .addComponent(halloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(dailyPlannerInternalFrameLayout.createSequentialGroup()
                                .addComponent(choseDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(55, 55, 55)))
                        .addGroup(dailyPlannerInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(appointmentsPannel))
                .addContainerGap())
        );
        dailyPlannerInternalFrameLayout.setVerticalGroup(
            dailyPlannerInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dailyPlannerInternalFrameLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(dailyPlannerInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(halloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(CurrentDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dailyPlannerInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(get_setAppButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appointmentsPannel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        get_setAppButton.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(dailyPlannerInternalFrame)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dailyPlannerInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void get_setAppButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_setAppButtonActionPerformed
        // TODO add your handling code here:
        mainCalendar.setDate(DateChooser.getDate());
        /*
         if(!wwf.isEmpty()){
         wwf.readInfromationFromFile();
        }
        */ 
    }//GEN-LAST:event_get_setAppButtonActionPerformed

    private void dailyPlannerInternalFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dailyPlannerInternalFrameAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dailyPlannerInternalFrameAncestorAdded

    private void dailyAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyAddButtonActionPerformed
        // add new appointment
        AddNewAppointment addApp = new AddNewAppointment(wwhm);
        addApp.setVisible(true);
    }//GEN-LAST:event_dailyAddButtonActionPerformed

    private void weeklyAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyAddButtonActionPerformed
            //add new appointment
            AddNewAppointment addApp = new AddNewAppointment(wwhm);
            addApp.setVisible(true);
    }//GEN-LAST:event_weeklyAddButtonActionPerformed

    private void dailyEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyEditButtonActionPerformed
        // TODO add your handling code here:
         EditAppointment eApp = new EditAppointment(wwhm);
         eApp.setVisible(true);
    }//GEN-LAST:event_dailyEditButtonActionPerformed

    private void dailyDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyDeleteButtonActionPerformed
        // TODO add your handling code here:
         index = this.dailyListOfApp.getSelectedIndex();
         dailyListOfApp.setModel(myModel);
         String nameOfAppointment = myModel.get(index).toString();
         wwhm.deleteAppointmentFromHashMap(nameOfAppointment);
    }//GEN-LAST:event_dailyDeleteButtonActionPerformed

    private void weeklyEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyEditButtonActionPerformed
        // TODO add your handling code here:
         EditAppointment eApp = new EditAppointment(wwhm);
         eApp.setVisible(true);
    }//GEN-LAST:event_weeklyEditButtonActionPerformed

    private void weeklyDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyDeleteButtonActionPerformed
        // TODO add your handling code here:
         index = this.weeklyListOfApp.getSelectedIndex();
         weeklyListOfApp.setModel(myModel);
         String nameOfAppointment = myModel.get(index).toString();
         wwhm.deleteAppointmentFromHashMap(nameOfAppointment);
    }//GEN-LAST:event_weeklyDeleteButtonActionPerformed

    private void monthlyDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyDeleteButtonActionPerformed
        // TODO add your handling code here:
        index = this.monthlyListOfApp.getSelectedIndex();
        monthlyListOfApp.setModel(myModel);
        String nameOfAppointment = myModel.get(index).toString();
        wwhm.deleteAppointmentFromHashMap(nameOfAppointment);
    }//GEN-LAST:event_monthlyDeleteButtonActionPerformed

    private void monthlyEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyEditButtonActionPerformed

        EditAppointment eApp = new EditAppointment(wwhm);
        eApp.setVisible(true);
    }//GEN-LAST:event_monthlyEditButtonActionPerformed

    private void monthlyAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyAddButtonActionPerformed
        // add new appointment
        AddNewAppointment addApp = new AddNewAppointment(wwhm);
        addApp.setVisible(true);
    }//GEN-LAST:event_monthlyAddButtonActionPerformed
    
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DayPlanner().setVisible(true);
            }
            
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CurrentDateLabel;
    private com.toedter.calendar.JDateChooser DateChooser;
    public javax.swing.JTabbedPane appointmentsPannel;
    private javax.swing.JLabel choseDateLabel;
    private javax.swing.JLabel dAppLabel;
    private javax.swing.JTextField dDescriptionTextField;
    private javax.swing.JButton dailyAddButton;
    private javax.swing.JButton dailyDeleteButton;
    private javax.swing.JLabel dailyDescriptionLabel;
    private javax.swing.JButton dailyEditButton;
    public javax.swing.JList<String> dailyListOfApp;
    private javax.swing.JInternalFrame dailyPlannerInternalFrame;
    private javax.swing.JButton get_setAppButton;
    private javax.swing.JLabel halloLabel;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel mAppLabel;
    private javax.swing.JTextField mDescriptionTextField;
    static com.toedter.calendar.JCalendar mainCalendar;
    private javax.swing.JButton monthlyAddButton;
    private javax.swing.JButton monthlyDeleteButton;
    private javax.swing.JLabel monthlyDescriptionLabel;
    private javax.swing.JButton monthlyEditButton;
    public javax.swing.JList<String> monthlyListOfApp;
    private javax.swing.JLabel wAppLabel;
    private javax.swing.JTextField wDescriptionTextField;
    private javax.swing.JButton weeklyAddButton;
    private javax.swing.JButton weeklyDeleteButton;
    private javax.swing.JLabel weeklyDescriptionLabel;
    private javax.swing.JButton weeklyEditButton;
    public javax.swing.JList<String> weeklyListOfApp;
    // End of variables declaration//GEN-END:variables
}
