/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examsdesktopapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Maria
 */
public class SysAdminJFrame extends javax.swing.JFrame {
    
    private SysAdminBean sys_admin;

    /** Creates new form SysAdminJFrame */
    public SysAdminJFrame(SysAdminBean bean) {
        this.sys_admin = bean;
        initComponents();
    }
    
    void ShowMessage (String Title, String Message, int Type)
    {
        JOptionPane.showMessageDialog (this, Message, Title, Type);
    }
    
    private void refresh() {
        selectAdmin_jComboBox.setModel(usersList());
        selectExamCenter_jComboBox.setModel(examCentersList());
        selectExamC_jComboBox.setModel(examCentersList());
    }
    
    
    private javax.swing.DefaultComboBoxModel usersList() {
        String[] users = SysAdminProcesses.getUsersToString();
        if(users.length==0) {
            selectAdmin_jComboBox.setVisible(false);
            addAdmin_jButton.setVisible(false);
            noUsers_jLabel.setVisible(true);
        } else {
            selectAdmin_jComboBox.setVisible(true);
            addAdmin_jButton.setVisible(true);
            noUsers_jLabel.setVisible(false);
        }
        javax.swing.DefaultComboBoxModel dm = new javax.swing.DefaultComboBoxModel(users);
        return dm;
    }
    
    
    private javax.swing.DefaultComboBoxModel examCentersList() {
        String[] examCenters = SysAdminProcesses.getExamCentersToString();
        if(examCenters.length==0) {
            selectExamCenter_jComboBox.setVisible(false);
            selectExamC_jComboBox.setVisible(false);
            addAdmin_jButton.setVisible(false);
            addExam_jButton.setVisible(false);
            noExamCenters_jLabel.setVisible(true);
            noExamCenters_jLabel1.setVisible(true);
        } else {
            selectExamCenter_jComboBox.setVisible(true);
            selectExamC_jComboBox.setVisible(true);
            addAdmin_jButton.setVisible(true);
            addExam_jButton.setVisible(true);
            noExamCenters_jLabel.setVisible(false);
            noExamCenters_jLabel1.setVisible(false);
        }
        javax.swing.DefaultComboBoxModel dm = new javax.swing.DefaultComboBoxModel(examCenters);
        return dm;
    }
    
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sysAdmin_jTabbedPane = new javax.swing.JTabbedPane();
        addUser_jPanel = new javax.swing.JPanel();
        userInfo_jLabel = new javax.swing.JLabel();
        userName_jLabel = new javax.swing.JLabel();
        userUsername_jLabel = new javax.swing.JLabel();
        userPass_jLabel = new javax.swing.JLabel();
        userPassConfirm_jLabel = new javax.swing.JLabel();
        userName_jTextField = new javax.swing.JTextField();
        userUsername_jTextField = new javax.swing.JTextField();
        userPass_jPasswordField = new javax.swing.JPasswordField();
        userPassConfirm_jPasswordField = new javax.swing.JPasswordField();
        addUser_jButton = new javax.swing.JButton();
        addExamCenter_jPanel = new javax.swing.JPanel();
        examCenterInfo_jLabel = new javax.swing.JLabel();
        examCenterName_jLabel = new javax.swing.JLabel();
        examCenterAddress_jLabel = new javax.swing.JLabel();
        examCenterName_jTextField = new javax.swing.JTextField();
        examCenterAddress_jTextField = new javax.swing.JTextField();
        addCenter_jButton = new javax.swing.JButton();
        addAdmin_jPanel = new javax.swing.JPanel();
        selectExamCenter_jLabel = new javax.swing.JLabel();
        selectExamCenter_jComboBox = new javax.swing.JComboBox<>();
        selectAdmin_jLabel = new javax.swing.JLabel();
        addAdmin_jButton = new javax.swing.JButton();
        selectAdmin_jComboBox = new javax.swing.JComboBox<>();
        refresh_jButton = new javax.swing.JButton();
        noExamCenters_jLabel = new javax.swing.JLabel();
        noUsers_jLabel = new javax.swing.JLabel();
        addExam_jPanel = new javax.swing.JPanel();
        selectExamC_jLabel = new javax.swing.JLabel();
        selectExamC_jComboBox = new javax.swing.JComboBox<>();
        date_jLabel = new javax.swing.JLabel();
        time_jLabel = new javax.swing.JLabel();
        time_timePicker = new com.github.lgooddatepicker.components.TimePicker();
        date_datePicker = new com.github.lgooddatepicker.components.DatePicker();
        addExam_jButton = new javax.swing.JButton();
        noExamCenters_jLabel1 = new javax.swing.JLabel();
        refresh_jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userInfo_jLabel.setText("Add user's information:");

        userName_jLabel.setText("Name:");

        userUsername_jLabel.setText("Username:");

        userPass_jLabel.setText("Password:");

        userPassConfirm_jLabel.setText("Confirm password:");

        userName_jTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userName_jTextFieldActionPerformed(evt);
            }
        });

        addUser_jButton.setText("Add new user");
        addUser_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUser_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addUser_jPanelLayout = new javax.swing.GroupLayout(addUser_jPanel);
        addUser_jPanel.setLayout(addUser_jPanelLayout);
        addUser_jPanelLayout.setHorizontalGroup(
            addUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUser_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userInfo_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userName_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userUsername_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPassConfirm_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPass_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(addUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userName_jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(userUsername_jTextField)
                    .addComponent(userPass_jPasswordField)
                    .addComponent(userPassConfirm_jPasswordField))
                .addGap(137, 137, 137))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUser_jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addUser_jButton)
                .addContainerGap())
        );
        addUser_jPanelLayout.setVerticalGroup(
            addUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUser_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userInfo_jLabel)
                .addGap(18, 18, 18)
                .addGroup(addUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName_jLabel)
                    .addComponent(userName_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userUsername_jLabel)
                    .addComponent(userUsername_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPass_jLabel)
                    .addComponent(userPass_jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPassConfirm_jLabel)
                    .addComponent(userPassConfirm_jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(addUser_jButton)
                .addContainerGap())
        );

        sysAdmin_jTabbedPane.addTab("Add new users", addUser_jPanel);

        examCenterInfo_jLabel.setText("Add information of exam center:");

        examCenterName_jLabel.setText("Name:");

        examCenterAddress_jLabel.setText("Address:");

        addCenter_jButton.setText("Add Center");
        addCenter_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCenter_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addExamCenter_jPanelLayout = new javax.swing.GroupLayout(addExamCenter_jPanel);
        addExamCenter_jPanel.setLayout(addExamCenter_jPanelLayout);
        addExamCenter_jPanelLayout.setHorizontalGroup(
            addExamCenter_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addExamCenter_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addExamCenter_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(examCenterInfo_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(examCenterName_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(examCenterAddress_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(addExamCenter_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(examCenterName_jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(examCenterAddress_jTextField))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addExamCenter_jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addCenter_jButton)
                .addContainerGap())
        );
        addExamCenter_jPanelLayout.setVerticalGroup(
            addExamCenter_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addExamCenter_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(examCenterInfo_jLabel)
                .addGap(18, 18, 18)
                .addGroup(addExamCenter_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examCenterName_jLabel)
                    .addComponent(examCenterName_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addExamCenter_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examCenterAddress_jLabel)
                    .addComponent(examCenterAddress_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(addCenter_jButton)
                .addContainerGap())
        );

        sysAdmin_jTabbedPane.addTab("Add exam center", addExamCenter_jPanel);

        selectExamCenter_jLabel.setText("Select exam center:");

        selectExamCenter_jComboBox.setModel(examCentersList());

        selectAdmin_jLabel.setText("Select Adminestrator from users:");

        addAdmin_jButton.setText("Add new Administrator");
        addAdmin_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdmin_jButtonActionPerformed(evt);
            }
        });

        selectAdmin_jComboBox.setModel(usersList());

        refresh_jButton.setText("Refresh");
        refresh_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_jButtonActionPerformed(evt);
            }
        });

        noExamCenters_jLabel.setText("There are no exam centers!");

        noUsers_jLabel.setText("There are no users to be added as Administrators!");

        javax.swing.GroupLayout addAdmin_jPanelLayout = new javax.swing.GroupLayout(addAdmin_jPanel);
        addAdmin_jPanel.setLayout(addAdmin_jPanelLayout);
        addAdmin_jPanelLayout.setHorizontalGroup(
            addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAdmin_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addAdmin_jPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refresh_jButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addAdmin_jButton))
                    .addGroup(addAdmin_jPanelLayout.createSequentialGroup()
                        .addGroup(addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectExamCenter_jLabel)
                            .addComponent(selectExamCenter_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noExamCenters_jLabel))
                        .addGap(155, 155, 155)
                        .addGroup(addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noUsers_jLabel)
                            .addComponent(selectAdmin_jLabel)
                            .addComponent(selectAdmin_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addAdmin_jPanelLayout.setVerticalGroup(
            addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAdmin_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectExamCenter_jLabel)
                    .addComponent(selectAdmin_jLabel))
                .addGap(18, 18, 18)
                .addGroup(addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectExamCenter_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectAdmin_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noExamCenters_jLabel)
                    .addComponent(noUsers_jLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addGroup(addAdmin_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAdmin_jButton)
                    .addComponent(refresh_jButton))
                .addContainerGap())
        );

        sysAdmin_jTabbedPane.addTab("Add Administrator of exam center", addAdmin_jPanel);

        selectExamC_jLabel.setText("Select Exam Center:");

        selectExamC_jComboBox.setModel(examCentersList());

        date_jLabel.setText("Date:");

        time_jLabel.setText("Time:");

        addExam_jButton.setText("Add exam");
        addExam_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExam_jButtonActionPerformed(evt);
            }
        });

        noExamCenters_jLabel1.setText("There are no exam centers!");

        refresh_jButton1.setText("Refresh");
        refresh_jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addExam_jPanelLayout = new javax.swing.GroupLayout(addExam_jPanel);
        addExam_jPanel.setLayout(addExam_jPanelLayout);
        addExam_jPanelLayout.setHorizontalGroup(
            addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addExam_jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh_jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addExam_jButton)
                .addContainerGap())
            .addGroup(addExam_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectExamC_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectExamC_jLabel)
                    .addComponent(noExamCenters_jLabel1))
                .addGap(144, 144, 144)
                .addGroup(addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(time_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(time_timePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        addExam_jPanelLayout.setVerticalGroup(
            addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addExam_jPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addExam_jPanelLayout.createSequentialGroup()
                        .addGroup(addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date_datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addExam_jButton)
                            .addComponent(refresh_jButton1)))
                    .addGroup(addExam_jPanelLayout.createSequentialGroup()
                        .addComponent(selectExamC_jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectExamC_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addExam_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noExamCenters_jLabel1)
                            .addComponent(time_jLabel)
                            .addComponent(time_timePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 241, Short.MAX_VALUE)))
                .addContainerGap())
        );

        sysAdmin_jTabbedPane.addTab("Add new exam", addExam_jPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sysAdmin_jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sysAdmin_jTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userName_jTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userName_jTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userName_jTextFieldActionPerformed

    private void refresh_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_jButtonActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_refresh_jButtonActionPerformed

    private void addAdmin_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdmin_jButtonActionPerformed
        // TODO add your handling code here:
        String exam_center = selectExamCenter_jComboBox.getSelectedItem().toString();
        String user = selectAdmin_jComboBox.getSelectedItem().toString();
        String finish = " | Name";
        String ecStr = exam_center.substring(4, exam_center.indexOf(finish));
        int ecId = Integer.parseInt(ecStr);
        String uStr = user.substring(9, user.indexOf(finish));
        int uId = Integer.parseInt(uStr);
        if(SysAdminProcesses.addAdminFromUsers(uId, ecId)) {
            ShowMessage ("Admin added succesfully!", ("New admin was added."), JOptionPane.PLAIN_MESSAGE);
        } else {
            ShowMessage ("Adding new Admin failed!", ("Adding new admin failed."), JOptionPane.ERROR_MESSAGE);
        }
        refresh();
    }//GEN-LAST:event_addAdmin_jButtonActionPerformed

    private void addUser_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUser_jButtonActionPerformed
        // TODO add your handling code here:
        String name = userName_jTextField.getText();
        String uName = userUsername_jTextField.getText();
        String uPass = String.valueOf(userPass_jPasswordField.getPassword());
        String uPassConfirm = String.valueOf(userPassConfirm_jPasswordField.getPassword());
        if(name.isEmpty() || uName.isEmpty() || uPass.isEmpty() || uPassConfirm.isEmpty()) {
            ShowMessage ("Adding user failed!", ("One or more fields are empty.\nAll fields are required."), JOptionPane.ERROR_MESSAGE);
        } else {
            if(uPass.equals(uPassConfirm)) {
                UserBean user = new UserBean();
                user.setName(name);
                user.setUname(uName);
                user.setPass(uPass);
                if(SysAdminProcesses.addUser(user)) {
                    ShowMessage ("User added succesfully!", ("New user, " + user.getName() + ", was added."), JOptionPane.PLAIN_MESSAGE);
                } else {
                    ShowMessage ("Adding user failed!", ("Adding user failed maybe because this Username already exists."), JOptionPane.ERROR_MESSAGE);
                }
            } else {
                ShowMessage ("Adding user failed!", ("Password cofinrmation doesn't match password."), JOptionPane.ERROR_MESSAGE);
            }
            userName_jTextField.setText("");
            userUsername_jTextField.setText("");
            userPass_jPasswordField.setText("");
            userPassConfirm_jPasswordField.setText("");
        }
        
    }//GEN-LAST:event_addUser_jButtonActionPerformed

    private void addCenter_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCenter_jButtonActionPerformed
        // TODO add your handling code here:
        String name = examCenterName_jTextField.getText();
        String address = examCenterAddress_jTextField.getText();
        if(name.isEmpty() || address.isEmpty()) {
            ShowMessage ("Adding exam center failed!", ("One or more fields are empty.\nAll fields are required."), JOptionPane.ERROR_MESSAGE);
        } else {
            ExamCenter ec = new ExamCenter();
            ec.setName(name);
            ec.setAddress(address);
            if(SysAdminProcesses.addExamCenter(ec)) {
                ShowMessage ("Exam Center added succesfully!", ("New exam center, " + ec.getName() + ", was added."), JOptionPane.PLAIN_MESSAGE);
            } else {
                ShowMessage ("Adding exam center failed!", ("Adding exam center failed maybe because this name of exam center already exists."), JOptionPane.ERROR_MESSAGE);
            }
            examCenterName_jTextField.setText("");
            examCenterAddress_jTextField.setText("");
        }
    }//GEN-LAST:event_addCenter_jButtonActionPerformed

    private void refresh_jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_jButton1ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_refresh_jButton1ActionPerformed

    private void addExam_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExam_jButtonActionPerformed
        // TODO add your handling code here:
        String exam_center = selectExamCenter_jComboBox.getSelectedItem().toString();
        String finish = " | Name";
        String ecStr = exam_center.substring(4, exam_center.indexOf(finish));
        int ecId = Integer.parseInt(ecStr);
        String date = "";
        String time = "";
        date = date_datePicker.getDateStringOrEmptyString();
        time = time_timePicker.getTimeStringOrEmptyString();
        String t = time + ":00";
        if(date.equals("") || time.equals("")) {
            ShowMessage ("Adding exam failed!", ("One or more fields are empty or wrong.\nAll fields are required."), JOptionPane.ERROR_MESSAGE);
        } else {
            Exam ex = new Exam();
            ex.setEc_id(ecId);
            ex.setDateStr(date);
            ex.setTimeStr(t);
            if(SysAdminProcesses.addExam(ex)) {
                ShowMessage ("Exam added succesfully!", ("New exam was added to exam center with Id " + ex.getEc_id() + ".\nDate: "+ ex.getDateStr() +"\nTime: " + ex.getTimeStr()), JOptionPane.PLAIN_MESSAGE);
            } else {
                ShowMessage ("Adding exam failed!", ("Adding exam failed.\nSomething went wrong."), JOptionPane.ERROR_MESSAGE);
            }
        }
        
        refresh();
    }//GEN-LAST:event_addExam_jButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SysAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SysAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SysAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SysAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SysAdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdmin_jButton;
    private javax.swing.JPanel addAdmin_jPanel;
    private javax.swing.JButton addCenter_jButton;
    private javax.swing.JPanel addExamCenter_jPanel;
    private javax.swing.JButton addExam_jButton;
    private javax.swing.JPanel addExam_jPanel;
    private javax.swing.JButton addUser_jButton;
    private javax.swing.JPanel addUser_jPanel;
    private com.github.lgooddatepicker.components.DatePicker date_datePicker;
    private javax.swing.JLabel date_jLabel;
    private javax.swing.JLabel examCenterAddress_jLabel;
    private javax.swing.JTextField examCenterAddress_jTextField;
    private javax.swing.JLabel examCenterInfo_jLabel;
    private javax.swing.JLabel examCenterName_jLabel;
    private javax.swing.JTextField examCenterName_jTextField;
    private javax.swing.JLabel noExamCenters_jLabel;
    private javax.swing.JLabel noExamCenters_jLabel1;
    private javax.swing.JLabel noUsers_jLabel;
    private javax.swing.JButton refresh_jButton;
    private javax.swing.JButton refresh_jButton1;
    private javax.swing.JComboBox<String> selectAdmin_jComboBox;
    private javax.swing.JLabel selectAdmin_jLabel;
    private javax.swing.JComboBox<String> selectExamC_jComboBox;
    private javax.swing.JLabel selectExamC_jLabel;
    private javax.swing.JComboBox<String> selectExamCenter_jComboBox;
    private javax.swing.JLabel selectExamCenter_jLabel;
    private javax.swing.JTabbedPane sysAdmin_jTabbedPane;
    private javax.swing.JLabel time_jLabel;
    private com.github.lgooddatepicker.components.TimePicker time_timePicker;
    private javax.swing.JLabel userInfo_jLabel;
    private javax.swing.JLabel userName_jLabel;
    private javax.swing.JTextField userName_jTextField;
    private javax.swing.JLabel userPassConfirm_jLabel;
    private javax.swing.JPasswordField userPassConfirm_jPasswordField;
    private javax.swing.JLabel userPass_jLabel;
    private javax.swing.JPasswordField userPass_jPasswordField;
    private javax.swing.JLabel userUsername_jLabel;
    private javax.swing.JTextField userUsername_jTextField;
    // End of variables declaration//GEN-END:variables

}
