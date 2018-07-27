/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import db.Authorisation;
import feedback.Feedback_DAO;
import feedback.Feedback_DAO_Implt;
import javax.swing.JOptionPane;
import login_History.Login_History_DAO;
import login_History.Login_History_DAO_Implt;
import mobiles.Mobiles_DAO;
import mobiles.Mobiles_DAO_Implt;
import profile.Profile_DAO;
import profile.Profile_DAO_Implt;
import purchase.Purchase_Report_DAO;
import purchase.Purchase_Report_DAO_Implt;
import sale.Sales_Report_DAO;
import sale.Sales_Report_DAO_Implt;

/**
 *
 * @author aamir
 */
public class DeleteF extends javax.swing.JFrame {
    private String table_name;
    /** Creates new form Delete */
    public DeleteF() {
        initComponents();
    }
    public DeleteF(String table_name) {
        initComponents();
        this.table_name=table_name;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        jLabel1.setText("DELETE RECORD");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("ID :");

        id.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        delete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        back.setText("GO BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delete)
                                .addGap(32, 32, 32)
                                .addComponent(back))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(id)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(back))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Admin_Home a=new Admin_Home();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        switch(table_name){
            case "profiles":
                Profile_DAO pdao=new Profile_DAO_Implt();
                if(pdao.delete(Integer.valueOf(id.getText()))){
                    JOptionPane.showMessageDialog(this, "Profile Deleted Successfully");
                    if(Authorisation.id == Integer.valueOf(id.getText())){
                        Authorisation.status="denied";
                        Authorisation.role="";
                        Authorisation.id=0;
                        LogIn l=new LogIn();
                        l.setVisible(true);
                    }else{
                        Admin_Home a=new Admin_Home();
                        a.setVisible(true);
                    }
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Error in Deleting Profile");
                }
                break;
            case "mobile":
                Mobiles_DAO mdao=new Mobiles_DAO_Implt();
                if(mdao.delete(Integer.valueOf(id.getText()))){
                    JOptionPane.showMessageDialog(this, "Mobile Deleted Successfully");
                    Admin_Home a=new Admin_Home();
                    a.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Error in Deleting Mobile");
                }
                break;
            case "login_history":
                Login_History_DAO ldao=new Login_History_DAO_Implt();
                if(ldao.delete(Integer.valueOf(id.getText()))){
                    JOptionPane.showMessageDialog(this, "Login History Deleted Successfully");
                    Admin_Home a=new Admin_Home();
                    a.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Error in Deleting Login History");
                }
                break;
            case "feedback":
                Feedback_DAO fdao=new Feedback_DAO_Implt();
                if(fdao.delete(Integer.valueOf(id.getText()))){
                    JOptionPane.showMessageDialog(this, "Feedback Deleted Successfully");
                    Admin_Home a=new Admin_Home();
                    a.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Error in Deleting Feedback");
                }
                break;
            case "sales_report":
                Sales_Report_DAO sdao=new Sales_Report_DAO_Implt();
                if(sdao.delete(Integer.valueOf(id.getText()))){
                    JOptionPane.showMessageDialog(this, "Sales Report Deleted Successfully");
                    Admin_Home a=new Admin_Home();
                    a.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Error in Deleting Sales Report");
                }
                break;
            case "purchase_report":
                Purchase_Report_DAO prdao=new Purchase_Report_DAO_Implt();
                if(prdao.delete(Integer.valueOf(id.getText()))){
                    JOptionPane.showMessageDialog(this, "Purchase Report Deleted Successfully");
                    Admin_Home a=new Admin_Home();
                    a.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Error in Deleting Purchase Report");
                }
                break;
        }
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
