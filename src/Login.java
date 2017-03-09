
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        btnSignUp = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Prestige Elite Std", 1, 18)); // NOI18N
        jLabel1.setText("PASSWORD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 150, 120, 30);

        jLabel2.setFont(new java.awt.Font("Prestige Elite Std", 1, 18)); // NOI18N
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 70, 120, 30);
        getContentPane().add(txtnama);
        txtnama.setBounds(140, 110, 180, 30);

        btnSignUp.setText("Sign UP");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp);
        btnSignUp.setBounds(80, 290, 80, 30);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(220, 290, 80, 30);

        btnSignIn.setText("Sign In");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignIn);
        btnSignIn.setBounds(360, 290, 80, 30);
        getContentPane().add(txtpass);
        txtpass.setBounds(150, 190, 170, 30);

        setBounds(0, 0, 569, 453);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        String username = txtnama.getText();
        String password = txtpass.getText();
        
        try {
            try (Statement statement = (Statement) file_koneksi.GetConnection().createStatement()) {
                statement.executeUpdate("insert into tb_alun(username, password) VALUES ('"+username+"','"+password+"');");
            } JOptionPane.showMessageDialog(null, "Selamat! anda berhasil sign Up");
            
        } catch (Exception t){
            JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi lagi prosedur");
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        // TODO add your handling code here:
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_testkoneksi?zeroDateTimeBehavior=convertToNull","root","");
            ps = connection.prepareStatement("SELECT 'username', 'password' FROM 'tb_akun' WHERE 'username' = ? AND 'password' = ?");
            ps.setString(1, txtnama.getText());
            ps.setString(2, txtpass.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                new frmMain().show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                txtpass.setText("");
                txtnama.requestFocus();
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "gagal");
        }
        
    }//GEN-LAST:event_btnSignInActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
