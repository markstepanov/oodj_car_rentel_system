/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_car_rental_system.JForms;

import oodj_car_rental_system.App;
import oodj_car_rental_system.ApplicationContext.ApplicationContext;
import oodj_car_rental_system.Entities.cars.Car;
import org.checkerframework.checker.units.qual.A;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author mark
 */
public class ManageCars extends javax.swing.JFrame {

    private ApplicationContext context;
    private ArrayList<Car> cars;

    private DefaultTableModel table;

    public void setContext(ApplicationContext context) {
        this.context = context;
        this.table = (DefaultTableModel) this.jTable1.getModel();
    }


    /**
     * Creates new form CustomerDashboard
     */
    public ManageCars() {
        initComponents();
        this.setSize(720, 480);
    }

    /**
     * This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                add_new_car_btn = new javax.swing.JButton();
                back_btn = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                edit_car = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowOpened(java.awt.event.WindowEvent evt) {
                                formWindowOpened(evt);
                        }
                });

                add_new_car_btn.setText("add new car");
                add_new_car_btn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                add_new_car_btnActionPerformed(evt);
                        }
                });

                back_btn.setText("back");
                back_btn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                back_btnActionPerformed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                jLabel1.setText("Car Managment");

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "id", "Model", "Price Per Hour", "Type", "Fuel", "Seats", "GearBox", "In Stock"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jScrollPane1.setViewportView(jTable1);
                if (jTable1.getColumnModel().getColumnCount() > 0) {
                        jTable1.getColumnModel().getColumn(0).setResizable(false);
                        jTable1.getColumnModel().getColumn(1).setResizable(false);
                        jTable1.getColumnModel().getColumn(2).setResizable(false);
                        jTable1.getColumnModel().getColumn(3).setResizable(false);
                        jTable1.getColumnModel().getColumn(4).setResizable(false);
                        jTable1.getColumnModel().getColumn(5).setResizable(false);
                        jTable1.getColumnModel().getColumn(6).setResizable(false);
                        jTable1.getColumnModel().getColumn(7).setResizable(false);
                }

                edit_car.setText("Edit Car");
                edit_car.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                edit_carActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                                .addComponent(add_new_car_btn)
                                .addGap(34, 34, 34)
                                .addComponent(back_btn)
                                .addGap(32, 32, 32))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(edit_car)
                                .addGap(29, 29, 29))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(add_new_car_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(edit_car, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void add_new_car_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_car_btnActionPerformed
        NewCarDashboard newCarDashboard = new NewCarDashboard();
        newCarDashboard.setContext(context);
        newCarDashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_add_new_car_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setContext(context);
        adminDashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void edit_carActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_carActionPerformed
        try{
            navigateToEditCarPage();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,  e.getMessage());
        }
    }//GEN-LAST:event_edit_carActionPerformed

    private void  navigateToEditCarPage() throws Exception{
        int id;
        try {
            id = Integer.parseInt(this.table.getValueAt(this.jTable1.getSelectedRow(), 0).toString());
        } catch (Exception e) {
            throw  new Exception("Please Choose the Car to Edit");
        }

        Car car;
        try {
            car = this.context.getCarRepository().getCarById(id).orElseThrow();
        } catch (Exception e){
            throw new Exception("Something went wrong");
        }

        if (!car.isInStock()){
            throw new Exception("You cant edit car while in renting!");
        }

        EditCarDashboard editCarDashboard  = new EditCarDashboard();
        editCarDashboard.setCar(car);
        editCarDashboard.setContext(context);
        editCarDashboard.setVisible(true);
        dispose();
    }

        private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            this.context.getCarRepository().getAllCars().ifPresent(cars -> this.cars = cars);
            if (this.cars == null) return;
            fillTheTable();
        }//GEN-LAST:event_formWindowOpened

    private void fillTheTable() {
        for (Car car : this.cars) {
            this.table.insertRow(table.getRowCount(),
                    new Object[]{
                            car.getId(), car.getName(), car.getPricePerHour(), car.getCarType(),
                            car.getCarFuel(), car.getSeats(), car.getGearBoxType(), car.isInStock()
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
            java.util.logging.Logger.getLogger(ManageCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCars().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton add_new_car_btn;
        private javax.swing.JButton back_btn;
        private javax.swing.JButton edit_car;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
        // End of variables declaration//GEN-END:variables
}
