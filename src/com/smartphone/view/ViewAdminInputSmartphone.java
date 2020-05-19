/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.view;

import com.smartphone.controller.SmartphoneController;
import com.smartphone.database.ConnectDatabase;
import com.smartphone.entitas.Smartphone;
import com.smartphone.error.SmartphoneException;
import com.smartphone.error.UserException;
import com.smartphone.event.SmartphoneListener;
import com.smartphone.model.SmartphoneModel;
import com.smartphone.model.TableModelSmartphone;
import com.smartphone.service.SmartphoneDao;
import com.smartphone.session.Session;
import java.sql.SQLException;
import java.util.logging.Level;
import java.awt.Cursor;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DASP
 */
public class ViewAdminInputSmartphone extends javax.swing.JFrame implements SmartphoneListener, ListSelectionListener {
    private final SmartphoneController controller;
    private final SmartphoneModel model;
    private final TableModelSmartphone tableModel;
    /**
     * Creates new form ViewUserPesan
     */
    public ViewAdminInputSmartphone() {
        tableModel = new TableModelSmartphone();
        model = new SmartphoneModel();
        model.setLstn(this);
        controller = new SmartphoneController();
        controller.setModel(model);
        initComponents();
        tablesmartphone.getSelectionModel().addListSelectionListener(this);
        tablesmartphone.setModel(tableModel);      
    }

    public JTextField getTxtid() {
        return txtid;
    }

    public void setTxtid(JTextField txtid) {
        this.txtid = txtid;
    }

    public JTextField getTxtbattery() {
        return txtbattery;
    }

    public void setTxtbattery(JTextField txtbattery) {
        this.txtbattery = txtbattery;
    }

    public JTextField getTxtcpu() {
        return txtcpu;
    }

    public void setTxtcpu(JTextField txtcpu) {
        this.txtcpu = txtcpu;
    }

    public JTextField getTxtgpu() {
        return txtgpu;
    }

    public void setTxtgpu(JTextField txtgpu) {
        this.txtgpu = txtgpu;
    }

    public JTextField getTxtharga() {
        return txtharga;
    }

    public void setTxtharga(JTextField txtharga) {
        this.txtharga = txtharga;
    }

    public JTextField getTxtkamera() {
        return txtkamera;
    }

    public void setTxtkamera(JTextField txtkamera) {
        this.txtkamera = txtkamera;
    }

    public JTextField getTxtlayar() {
        return txtlayar;
    }

    public void setTxtlayar(JTextField txtlayar) {
        this.txtlayar = txtlayar;
    }

    public JTextField getTxtmerk() {
        return txtmerk;
    }

    public void setTxtmerk(JTextField txtmerk) {
        this.txtmerk = txtmerk;
    }

    public JTextField getTxtnama() {
        return txtnama;
    }

    public void setTxtnama(JTextField txtnama) {
        this.txtnama = txtnama;
    }

    public JTextField getTxtos() {
        return txtos;
    }

    public void setTxtos(JTextField txtos) {
        this.txtos = txtos;
    }

    public JTextField getTxtram() {
        return txtram;
    }

    public void setTxtram(JTextField txtram) {
        this.txtram = txtram;
    }

    public JTextField getTxtrilis() {
        return txtrilis;
    }

    public void setTxtrilis(JTextField txtrilis) {
        this.txtrilis = txtrilis;
    }

    public JTextField getTxtstok() {
        return txtstok;
    }

    public void setTxtstok(JTextField txtstok) {
        this.txtstok = txtstok;
    }

    public JTable getTablesmartphone() {
        return tablesmartphone;
    }

    public void setTablesmartphone(JTable tablesmartphone) {
        this.tablesmartphone = tablesmartphone;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtmerk = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtrilis = new javax.swing.JTextField();
        txtlayar = new javax.swing.JTextField();
        txtkamera = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtos = new javax.swing.JTextField();
        txtcpu = new javax.swing.JTextField();
        txtgpu = new javax.swing.JTextField();
        txtram = new javax.swing.JTextField();
        txtbattery = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablesmartphone = new javax.swing.JTable();
        btnhapus = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 4, 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Input Data Smartphone");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("PESANAN USER");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("DASHBOARD");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("SMARTPHONE");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 16, 65));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Nama HP");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 45, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Merk");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 86, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Harga");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 127, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Rilis");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 168, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Layar");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 209, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Kamera");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 250, -1, -1));
        jPanel2.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 41, 142, -1));
        jPanel2.add(txtmerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 82, 142, -1));
        jPanel2.add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 123, 142, -1));
        jPanel2.add(txtrilis, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 164, 142, -1));
        jPanel2.add(txtlayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 205, 142, -1));
        jPanel2.add(txtkamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 246, 142, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("OS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 45, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("CPU");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 86, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("GPU");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 127, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("RAM");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 168, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Battery");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 209, -1, -1));
        jPanel2.add(txtos, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 41, 142, -1));
        jPanel2.add(txtcpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 82, 142, -1));
        jPanel2.add(txtgpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 123, 142, -1));
        jPanel2.add(txtram, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 164, 142, -1));
        jPanel2.add(txtbattery, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 205, 142, -1));

        tablesmartphone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablesmartphone);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 710, 109));

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 275, -1, -1));

        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });
        jPanel2.add(btnubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 275, -1, -1));

        btnsimpan.setText("Tambah");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 275, -1, -1));

        jButton4.setBackground(new java.awt.Color(186, 6, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 324, -1, -1));

        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Stok");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 250, -1, -1));
        jPanel2.add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 246, 142, -1));

        jButton1.setText("Batal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 275, -1, -1));

        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("ID");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, -1, -1));

        txtid.setEditable(false);
        txtid.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtidPropertyChange(evt);
            }
        });
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 6, 142, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        controller.deleteSmartphone(this);
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        controller.insertSmartphone(this);
        ViewAdminInputSmartphone vau = new ViewAdminInputSmartphone();
        try {
            vau.loadDatabase();
        } catch (SQLException | SmartphoneException ex) {
            Logger.getLogger(ViewAdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        vau.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controller.resetForm(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        ViewAdminPesananUser vpu=new ViewAdminPesananUser();
        vpu.setVisible(true);
        dispose();

    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        jLabel8.setCursor(cursor);
        jLabel8.setVisible(true);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        ViewAdminUser vau = new ViewAdminUser();
        try {
            vau.loadDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(ViewAdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserException ex) {
            Logger.getLogger(ViewAdminInputSmartphone.class.getName()).log(Level.SEVERE, null, ex);
        }
        vau.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        jLabel16.setCursor(cursor);
        jLabel16.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void txtidPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtidPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidPropertyChange

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
        controller.updateSmartphone(this);
    }//GEN-LAST:event_btnubahActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        jLabel17.setCursor(cursor);
        jLabel17.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ViewLogin vl = new ViewLogin();
        Session.setUsername("");
        vl.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAdminInputSmartphone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAdminInputSmartphone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAdminInputSmartphone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAdminInputSmartphone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAdminInputSmartphone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablesmartphone;
    private javax.swing.JTextField txtbattery;
    private javax.swing.JTextField txtcpu;
    private javax.swing.JTextField txtgpu;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtkamera;
    private javax.swing.JTextField txtlayar;
    private javax.swing.JTextField txtmerk;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtos;
    private javax.swing.JTextField txtram;
    private javax.swing.JTextField txtrilis;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(SmartphoneModel model) {
        txtid.setText(model.getId()+"");
        txtnama.setText(model.getNama());
        txtmerk.setText(model.getMerk());
        txtharga.setText(model.getHarga()+"");
        txtrilis.setText(model.getRilis());
        txtlayar.setText(model.getLayar());
        txtkamera.setText(model.getKamera());
        txtos.setText(model.getOs());
        txtcpu.setText(model.getCpu());
        txtgpu.setText(model.getGpu());
        txtram.setText(model.getRam());
        txtbattery.setText(model.getBattery());
        txtstok.setText(model.getStok()+"");
    }

    @Override
    public void onInsert(Smartphone s) {
        tableModel.add(s);
    }

    @Override
    public void onUpdate(Smartphone s) {
        int index = tablesmartphone.getSelectedRow();
        tableModel.set(index, s);
    }

    @Override
    public void onDelete() {
        int index = tablesmartphone.getSelectedRow();
        tableModel.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try{
            Smartphone m = tableModel.get(tablesmartphone.getSelectedRow());
            txtid.setText(m.getId()+"");
            txtnama.setText(m.getNama());
            txtmerk.setText(m.getMerk());
            txtharga.setText(Integer.toString(m.getHarga()));
            txtrilis.setText(m.getRilis());
            txtlayar.setText(m.getLayar());
            txtkamera.setText(m.getKamera());
            txtos.setText(m.getOs());
            txtcpu.setText(m.getCpu());
            txtgpu.setText(m.getGpu());
            txtram.setText(m.getRam());
            txtbattery.setText(m.getBattery());
            txtstok.setText(Integer.toString(m.getStok()));
        }catch(IndexOutOfBoundsException ie){
            
        }
    }
    
    public void loadDatabase() throws SQLException, SmartphoneException{
        SmartphoneDao dao = ConnectDatabase.getSmartphoneDao();
        tableModel.setList(dao.selectAllSmartphone());
    }
}
