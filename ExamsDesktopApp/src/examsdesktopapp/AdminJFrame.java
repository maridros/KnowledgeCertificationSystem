/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsdesktopapp;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria
 */
public class AdminJFrame extends javax.swing.JFrame {
    
    private AdminBean admin;

    /**
     * Creates new form AdminJFrame
     * @param bean
     */
    public AdminJFrame(AdminBean bean) {
        this.admin = bean;
        initComponents();
        
    }
    
    void ShowMessage (String Title, String Message, int Type)
    {
        JOptionPane.showMessageDialog (this, Message, Title, Type);
    }
    
    private void refresh() {
        selectExamToAddUsers_jComboBox.setModel(ExamsList());
        userList_jList.setModel(usersList()); 
    }
   
    /*
    private javax.swing.DefaultListModel<UserBean> usersList() {
        javax.swing.DefaultListModel<UserBean> listModel = new javax.swing.DefaultListModel<>();
        ArrayList<UserBean> users = AdminProcesses.getUsers();
        for(int i=0; i<users.size(); i++)
            listModel.addElement(users.get(i));
        return listModel;
    }
    */
    
    private javax.swing.AbstractListModel<String> usersList() {
        return new javax.swing.AbstractListModel<String>() {
            String[] strings = AdminProcesses.getUsersToString();//usersList();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        };
    }
    
    /*
    private String[] usersList() {
        String[] users = AdminProcesses.getUsersToString();
        return users;
    }*/
    
    private javax.swing.DefaultComboBoxModel todayExamsList() {
        String[] exams = AdminProcesses.getTodayNonStartedExams(admin.getEc_id());
        if(exams.length==0) {
            selectExam_jComboBox.setVisible(false);
            selectExam_jLabel.setVisible(false);
            startExam_jButton.setVisible(false);
            NoExams_jLabel.setVisible(true);
        } else {
            selectExam_jComboBox.setVisible(true);
            selectExam_jLabel.setVisible(true);
            startExam_jButton.setVisible(true);
            NoExams_jLabel.setVisible(false);
        }
        javax.swing.DefaultComboBoxModel dm = new javax.swing.DefaultComboBoxModel(exams);
        return dm;    
    }
    
    private javax.swing.DefaultComboBoxModel ExamsList() {
        String[] exams = AdminProcesses.getNonStartedExams(admin.getEc_id());
        if(exams.length==0) {
            selectExamToAddUsers_jComboBox.setVisible(false);
            addUsers_jButton.setVisible(false);
            noExamsFound_jLabel.setVisible(true);
        } else {
            selectExamToAddUsers_jComboBox.setVisible(true);
            addUsers_jButton.setVisible(true);
            noExamsFound_jLabel.setVisible(false);
        }
        javax.swing.DefaultComboBoxModel dm = new javax.swing.DefaultComboBoxModel(exams);
        return dm;    
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
        Admin_jTabbedPane = new javax.swing.JTabbedPane();
        StartExam_jPanel = new javax.swing.JPanel();
        selectExam_jLabel = new javax.swing.JLabel();
        selectExam_jComboBox = new javax.swing.JComboBox<>();
        startExam_jButton = new javax.swing.JButton();
        NoExams_jLabel = new javax.swing.JLabel();
        searchExams_jButton = new javax.swing.JButton();
        AddUsersToExam_jPanel = new javax.swing.JPanel();
        selectExamToAddUsers_jLabel = new javax.swing.JLabel();
        selectExamToAddUsers_jComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList_jList = new javax.swing.JList<>();
        selectUsers_jLabel = new javax.swing.JLabel();
        addUsers_jButton = new javax.swing.JButton();
        noExamsFound_jLabel = new javax.swing.JLabel();
        refresh_jButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectExam_jLabel.setText("Select exam to start:");

        selectExam_jComboBox.setModel(todayExamsList());

        startExam_jButton.setText("Start Exam");
        startExam_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startExam_jButtonActionPerformed(evt);
            }
        });

        NoExams_jLabel.setText("There are no exams in your exams center to begin.");

        searchExams_jButton.setText("Search for exams");
        searchExams_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchExams_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StartExam_jPanelLayout = new javax.swing.GroupLayout(StartExam_jPanel);
        StartExam_jPanel.setLayout(StartExam_jPanelLayout);
        StartExam_jPanelLayout.setHorizontalGroup(
            StartExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartExam_jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchExams_jButton)
                .addGap(18, 18, 18)
                .addComponent(startExam_jButton)
                .addGap(58, 58, 58))
            .addGroup(StartExam_jPanelLayout.createSequentialGroup()
                .addGroup(StartExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StartExam_jPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(StartExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectExam_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectExam_jLabel)))
                    .addGroup(StartExam_jPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(NoExams_jLabel)))
                .addContainerGap(311, Short.MAX_VALUE))
        );
        StartExam_jPanelLayout.setVerticalGroup(
            StartExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartExam_jPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(selectExam_jLabel)
                .addGap(18, 18, 18)
                .addComponent(selectExam_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(NoExams_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(StartExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startExam_jButton)
                    .addComponent(searchExams_jButton))
                .addGap(39, 39, 39))
        );

        Admin_jTabbedPane.addTab("Start Exam", StartExam_jPanel);

        selectExamToAddUsers_jLabel.setText("Select exam to add users:");

        selectExamToAddUsers_jComboBox.setModel(ExamsList());

        userList_jList.setModel(usersList());
        jScrollPane1.setViewportView(userList_jList);

        selectUsers_jLabel.setText("Select users to add:");

        addUsers_jButton.setText("Add Users");
        addUsers_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUsers_jButtonActionPerformed(evt);
            }
        });

        noExamsFound_jLabel.setText("There are no exams in your exam center");

        refresh_jButton.setText("Refresh");
        refresh_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddUsersToExam_jPanelLayout = new javax.swing.GroupLayout(AddUsersToExam_jPanel);
        AddUsersToExam_jPanel.setLayout(AddUsersToExam_jPanelLayout);
        AddUsersToExam_jPanelLayout.setHorizontalGroup(
            AddUsersToExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddUsersToExam_jPanelLayout.createSequentialGroup()
                .addGroup(AddUsersToExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddUsersToExam_jPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(AddUsersToExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectExamToAddUsers_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectExamToAddUsers_jLabel)
                            .addComponent(noExamsFound_jLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddUsersToExam_jPanelLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(refresh_jButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addUsers_jButton)
                        .addGap(74, 74, 74)))
                .addGroup(AddUsersToExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectUsers_jLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        AddUsersToExam_jPanelLayout.setVerticalGroup(
            AddUsersToExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddUsersToExam_jPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(AddUsersToExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectExamToAddUsers_jLabel)
                    .addComponent(selectUsers_jLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddUsersToExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddUsersToExam_jPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(AddUsersToExam_jPanelLayout.createSequentialGroup()
                        .addComponent(selectExamToAddUsers_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(noExamsFound_jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AddUsersToExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addUsers_jButton)
                            .addComponent(refresh_jButton))
                        .addGap(20, 20, 20))))
        );

        Admin_jTabbedPane.addTab("Add Users to Exam", AddUsersToExam_jPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Admin_jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Admin_jTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchExams_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchExams_jButtonActionPerformed
        // TODO add your handling code here:
        selectExam_jComboBox.setModel(todayExamsList());
    }//GEN-LAST:event_searchExams_jButtonActionPerformed

    private void startExam_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startExam_jButtonActionPerformed
        // TODO add your handling code here
        String exam = selectExam_jComboBox.getSelectedItem().toString();
        String finish = " | Date:";
        String exIdStr = exam.substring(9, exam.indexOf(finish));
        int exId = Integer.parseInt(exIdStr);
        if(AdminProcesses.startExam(exId)){ 
            ShowMessage ("Exam started!", ("Exam with ID " + exId + " started successfully."), JOptionPane.PLAIN_MESSAGE);
            selectExam_jComboBox.setModel(todayExamsList());
        } else {
            ShowMessage ("Starting exam failed!", ("Could not start exam with ID " + exId + "."), JOptionPane.ERROR_MESSAGE);
            selectExam_jComboBox.setModel(todayExamsList());
        }
        
    }//GEN-LAST:event_startExam_jButtonActionPerformed

    private void addUsers_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUsers_jButtonActionPerformed
        // TODO add your handling code here:
        //get exam from jComboBox:
        String exam = selectExamToAddUsers_jComboBox.getSelectedItem().toString();
        String finish = " | Date:";
        String exIdStr = exam.substring(9, exam.indexOf(finish));
        int exId = Integer.parseInt(exIdStr);
        //get users from jList:
        ArrayList<String> users = new ArrayList<>(userList_jList.getSelectedValuesList());
        if(users.isEmpty()) {
            ShowMessage ("Adding users to exams failed!", ("No users were selected.\nYou must select users first."), JOptionPane.ERROR_MESSAGE);
        } else {
            finish = " | Name";
            ArrayList<Integer> usersId = new ArrayList();
            for(int i=0; i<users.size(); i++) {
                String uIdStr = users.get(i).substring(9, users.get(i).indexOf(finish));
                int uId = Integer.parseInt(uIdStr);
                usersId.add(uId);
            }
            //add users to exam:
            if(AdminProcesses.addUsersToExam(usersId, exId)) {
                ShowMessage ("Users were added successfully!", ("The selected users were added to exam with ID " + exId + "."), JOptionPane.PLAIN_MESSAGE);
            } else {
                ShowMessage ("Adding users to exams failed!", ("One or more users couldn't be added to exam."), JOptionPane.ERROR_MESSAGE);
            }
        }        
        refresh();
        
    }//GEN-LAST:event_addUsers_jButtonActionPerformed

    private void refresh_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_jButtonActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_refresh_jButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddUsersToExam_jPanel;
    private javax.swing.JTabbedPane Admin_jTabbedPane;
    private javax.swing.JLabel NoExams_jLabel;
    private javax.swing.JPanel StartExam_jPanel;
    private javax.swing.JButton addUsers_jButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel noExamsFound_jLabel;
    private javax.swing.JButton refresh_jButton;
    private javax.swing.JButton searchExams_jButton;
    private javax.swing.JComboBox<String> selectExamToAddUsers_jComboBox;
    private javax.swing.JLabel selectExamToAddUsers_jLabel;
    private javax.swing.JComboBox<String> selectExam_jComboBox;
    private javax.swing.JLabel selectExam_jLabel;
    private javax.swing.JLabel selectUsers_jLabel;
    private javax.swing.JButton startExam_jButton;
    private javax.swing.JList<String> userList_jList;
    // End of variables declaration//GEN-END:variables
}
