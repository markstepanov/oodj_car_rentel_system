/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_car_rental_system.JForms;

import oodj_car_rental_system.App;
import oodj_car_rental_system.ApplicationContext.ApplicationContext;
import oodj_car_rental_system.Entities.users.UserApplication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author mark
 */
public class NewUserApplications extends javax.swing.JFrame {

    private ApplicationContext context;
    private ArrayList<UserApplication> userApplications;

    private DefaultTableModel table;

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    /**
     * Creates new form CustomerDashboard
     */
    public NewUserApplications() {
        initComponents();
        this.setSize(720, 480);
        this.no_applications.setVisible(false);
        this.table = ((DefaultTableModel) this.jTable1.getModel());
    }

    /**
     * This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back_btn = new javax.swing.JButton();
        accept_btn = new javax.swing.JButton();
        decline_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        no_applications = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Username", "First Name", "Second Name", "Email"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        accept_btn.setText("Accept");
        accept_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accept_btnActionPerformed(evt);
            }
        });

        decline_btn.setText("Decline");
        decline_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decline_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("New Users Applications");

        no_applications.setText("No new applications");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(decline_btn)
                                                                .addGap(41, 41, 41)
                                                                .addComponent(accept_btn)
                                                                .addGap(30, 30, 30)))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(back_btn)
                                                .addGap(30, 30, 30))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(no_applications)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(back_btn)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(no_applications)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accept_btn)
                                        .addComponent(decline_btn))
                                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setContext(context);
        adminDashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void decline_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decline_btnActionPerformed

        String username;
        try {
            username = this.table.getValueAt(this.jTable1.getSelectedRow(), 0).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please choose the Application");
            return;
        }

        if (this.context.getUserRepository().deleteUserApplicationByUsername(username)) {
            this.table.removeRow(this.jTable1.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    }//GEN-LAST:event_decline_btnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadApplications();
    }//GEN-LAST:event_formWindowOpened

    private void accept_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accept_btnActionPerformed
        String username;
        try {
            username = this.table.getValueAt(this.jTable1.getSelectedRow(), 0).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please choose the Application");
            return;
        }

        if (this.context.getUserRepository().acceptUserApplicationByUsername(username)) {
            this.table.removeRow(this.jTable1.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    }//GEN-LAST:event_accept_btnActionPerformed

    private void loadApplications() {
        this.context.getUserRepository().getAllUserApplications()
                .ifPresent(userApplicationArrayList -> this.userApplications = userApplicationArrayList);
        if (!(this.userApplications == null || this.userApplications.isEmpty())) {
            fillTheTable();
        } else {
            this.no_applications.setVisible(true);
        }
    }

    private void fillTheTable() {
        for (UserApplication application : this.userApplications) {
            table.insertRow(table.getRowCount(), new Object[]{
                    application.getUsername(), application.getFirstName(), application.getSecondName(), application.getEmail()
            });
        }
    }

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
            java.util.logging.Logger.getLogger(NewUserApplications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUserApplications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUserApplications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUserApplications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUserApplications().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept_btn;
    private javax.swing.JButton back_btn;
    private javax.swing.JButton decline_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel no_applications;
    // End of variables declaration//GEN-END:variables
}
