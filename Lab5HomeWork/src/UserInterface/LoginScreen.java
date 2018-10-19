/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Abstract.User;
import Business.Users.Admin;
import Business.Users.Customer;
import Business.Users.Supplier;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author harshalneelkamal
 */
public class LoginScreen extends javax.swing.JPanel {

    /**
     * Creates new form LoginScreen
     */
    List<User> list;
    JPanel panelRight;
    private Admin admin;
    public LoginScreen(JPanel panelRight, List<User> list, Admin admin) {
        initComponents();
        this.list = list;
        this.panelRight = panelRight;
        this.admin = admin;
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        comboUser = new javax.swing.JComboBox<Object>();
        txtTitle = new javax.swing.JLabel();
        txtPswrd = new javax.swing.JPasswordField();

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtTitle.setText("Supplier Login Screen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogin)
                    .addComponent(comboUser, 0, 166, Short.MAX_VALUE)
                    .addComponent(txtTitle)
                    .addComponent(txtPswrd))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtTitle)
                .addGap(18, 18, 18)
                .addComponent(comboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtPswrd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if(list == admin.getCustDir().getCustomerList()){
            for(User user : admin.getCustDir().getCustomerList()){
                System.out.println("In for 1");
                if(user.getPassword().equals(txtPswrd.getText())){
                    CardLayout layout = (CardLayout)panelRight.getLayout();
                    panelRight.add(new SuccessScreen(user));
                    layout.next(panelRight);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Password Incorrect! Please enter the correct password.");
                }
            }
        }
        else if(list == admin.getSuppDir().getSupplierList())
        {
            System.out.println("In else 2");
            for(User user: admin.getSuppDir().getSupplierList()){
                System.out.println("In for2");
                if(user.getPassword().equals(txtPswrd.getText())){
                    CardLayout layout = (CardLayout)panelRight.getLayout();
                    panelRight.add(new SuccessScreen(user));
                    layout.next(panelRight);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Password Incorrect! Please enter the correct password.");
                }
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    
    private void initialize(){
        //text should either be "Supplier Login Screen" OR "Customer Login Screen"
        //Based on the selection
        comboUser.removeAllItems();
        //only customer or suppliers should be listed based on the selection
        if(list == admin.getCustDir().getCustomerList()){
            txtTitle.setText("Customer Login Screen");
            for(User user: admin.getCustDir().getCustomerList()){
                comboUser.addItem(user);
            }
        }
        else{
            txtTitle.setText("Supplier Login Screen");
            for(User user: admin.getSuppDir().getSupplierList()){
                comboUser.addItem(user);
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<Object> comboUser;
    private javax.swing.JPasswordField txtPswrd;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
