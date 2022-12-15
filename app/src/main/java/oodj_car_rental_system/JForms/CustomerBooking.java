/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_car_rental_system.JForms;

import oodj_car_rental_system.App;
import oodj_car_rental_system.ApplicationContext.ApplicationContext;
import oodj_car_rental_system.Entities.Bookings.Booking;
import oodj_car_rental_system.Entities.Bookings.BookingStatus;
import oodj_car_rental_system.Entities.cars.Car;
import oodj_car_rental_system.Entities.users.Customer;
import oodj_car_rental_system.utils.PricingFactor;

import javax.swing.*;
import java.util.Optional;

/**
 * @author mark
 */
public class CustomerBooking extends javax.swing.JFrame {

    private ApplicationContext context;
    private Customer customer;

    private Booking booking;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    /**
     * Creates new form CustomerDashboard
     */
    public CustomerBooking() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        model_name_lb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        price_per_hour_lb = new javax.swing.JLabel();
        car_type_lb = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        car_fuel_lb = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gearbox_lb = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        booking_status_lb = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        collect_car_btn = new javax.swing.JButton();
        end_rent_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel2.setText("My Booking");

        jLabel1.setText("Model: ");

        model_name_lb.setText("ModelName");

        jLabel4.setText("Price Per Hour:");

        price_per_hour_lb.setText("PricePerHour");

        car_type_lb.setText("CarType");

        jLabel7.setText("Car Type: ");

        car_fuel_lb.setText("CarFuel");

        jLabel9.setText("Car Fuel:");

        gearbox_lb.setText("CarFuel");

        jLabel11.setText("GearBox Type:");

        booking_status_lb.setText("BookingStatus");

        jLabel12.setText("Booking Status:");

        collect_car_btn.setText("Collect Car");
        collect_car_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collect_car_btnActionPerformed(evt);
            }
        });

        end_rent_btn.setText("End Rent");
        end_rent_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                end_rent_btnActionPerformed(evt);
            }
        });

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel4)
                                                                        .addGap(29, 29, 29))
                                                                .addComponent(jLabel7))
                                                        .addComponent(jLabel1))
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(model_name_lb)
                                                        .addComponent(car_type_lb)
                                                        .addComponent(price_per_hour_lb)))
                                        .addComponent(end_rent_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(collect_car_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12))
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(booking_status_lb)
                                                        .addComponent(gearbox_lb)
                                                        .addComponent(car_fuel_lb)))
                                        .addComponent(back_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(back_btn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(model_name_lb))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(price_per_hour_lb))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(car_type_lb)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(car_fuel_lb))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel11)
                                                        .addComponent(gearbox_lb))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(booking_status_lb))))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(collect_car_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(end_rent_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void collect_car_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collect_car_btnActionPerformed
        if (this.booking == null) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
            return;
        }

        if (!this.context.getBookingRepository().startBooking(this.booking)) {
            this.context.getCarRepository().changeCarStockStatus(booking.getRelatedToCar(), false);
            JOptionPane.showMessageDialog(null, "Something went wrong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Have a nice ride!");
        CustomerDashboard customerDashboard = new CustomerDashboard();
        customerDashboard.setContext(context);
        customerDashboard.setCustomer(customer);
        customerDashboard.setVisible(true);
        dispose();

    }//GEN-LAST:event_collect_car_btnActionPerformed

    private void end_rent_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_end_rent_btnActionPerformed
        if (this.booking == null) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
            return;
        }

        try {

            this.booking = this.context.getBookingRepository().closeBooking(booking).orElseThrow();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong");
            return;
        }

        this.context.getCarRepository().changeCarStockStatus(booking.getRelatedToCar(), true);
        Car car = this.context.getCarRepository().getCarById(booking.getRelatedToCar()).orElseThrow();
        float totalPrice = this.booking.calculateBookingPrice(car.getPricePerHour(), PricingFactor.HOURS);
        if (totalPrice == 0f){
            this.context.getUserRepository().withdrawalCustomerBalance(customer, car.getPricePerHour());
        } else {
            this.context.getUserRepository().withdrawalCustomerBalance(customer, totalPrice);
        }




        JOptionPane.showMessageDialog(null, "Have a nice ride!");
        CustomerDashboard customerDashboard = new CustomerDashboard();
        customerDashboard.setContext(context);
        customerDashboard.setCustomer(customer);
        customerDashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_end_rent_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        CustomerDashboard customerDashboard = new CustomerDashboard();
        customerDashboard.setCustomer(customer);
        customerDashboard.setContext(context);
        customerDashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Optional<Booking> bookingOptional = this.context.getBookingRepository().getCustomerValidBooking(this.customer);
        if (bookingOptional.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
            return;
        }
        Booking booking = bookingOptional.get();
        Optional<Car> carOptional = this.context.getCarRepository().getCarById(booking.getRelatedToCar());

        if (carOptional.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
            return;
        }

        Car car = carOptional.get();

        if (booking.getStatus().equals(BookingStatus.APPROVED)) {
            this.end_rent_btn.setEnabled(false);
        } else if (booking.getStatus().equals(BookingStatus.ACTIVE)) {
            this.collect_car_btn.setEnabled(false);
        }


        this.model_name_lb.setText(car.getName());
        this.price_per_hour_lb.setText(String.valueOf(car.getPricePerHour()));
        this.car_fuel_lb.setText(String.valueOf(car.getCarFuel()));
        this.car_type_lb.setText(String.valueOf(car.getCarType()));
        this.gearbox_lb.setText(String.valueOf(car.getGearBoxType()));
        this.booking_status_lb.setText(String.valueOf(booking.getStatus()));

        this.booking = booking;
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(CustomerBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel booking_status_lb;
    private javax.swing.JLabel car_fuel_lb;
    private javax.swing.JLabel car_type_lb;
    private javax.swing.JButton collect_car_btn;
    private javax.swing.JButton end_rent_btn;
    private javax.swing.JLabel gearbox_lb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel model_name_lb;
    private javax.swing.JLabel price_per_hour_lb;
    // End of variables declaration//GEN-END:variables
}