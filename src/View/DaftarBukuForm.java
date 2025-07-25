/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.BukuController;
import Model.Buku;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class DaftarBukuForm extends javax.swing.JFrame {
    private BukuController controller;

    public DaftarBukuForm(BukuController controller) {
        this.controller = controller;
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(211, 211, 211));
        
    tampilkanDataBuku();
    setTableCellAlignmentCenter();
  }
    private void tampilkanDataBuku(){
        tampilkanDataBuku("");
    }
    private void tampilkanDataBuku(String keyword) {
        DefaultTableModel tableModel = (DefaultTableModel) TabelBuku.getModel();
        List<Buku> daftarBuku = controller.getDaftarBuku();
        tableModel.setRowCount(0);
        
        int no = 1;
        for (Buku buku : daftarBuku) {
          if (keyword.isEmpty() || buku.getJudul().toLowerCase().contains(keyword.toLowerCase())) {
            String tahunSaja = buku.getTahunTerbit();
            if (tahunSaja.contains("-")) {
                tahunSaja = tahunSaja.split("-")[0];
            }

            Object[] row = {
                buku.getIdBuku(),
                buku.getJudul(),
                buku.getPengarang(),
                buku.getPenerbit(),
                tahunSaja,
                buku.getKategori()
            };
            tableModel.addRow(row);
            }
        }
       aturLebarKolom(); 
 }
    
    private void setTableCellAlignmentCenter() {
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

    for (int i = 0; i < TabelBuku.getColumnCount(); i++) {
        TabelBuku.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
}
    
    private void aturLebarKolom() {
        TabelBuku.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TabelBuku.getColumnModel().getColumn(0).setPreferredWidth(30); 
        TabelBuku.getColumnModel().getColumn(1).setPreferredWidth(200); 
        TabelBuku.getColumnModel().getColumn(2).setPreferredWidth(150); 
        TabelBuku.getColumnModel().getColumn(3).setPreferredWidth(200); 
        TabelBuku.getColumnModel().getColumn(4).setPreferredWidth(50); 
        TabelBuku.getColumnModel().getColumn(5).setPreferredWidth(70);
    }
    
    
    /**
     * Creates new form DaftarBukuForm
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelBuku = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblJudulBuku = new javax.swing.JLabel();
        txtJudulBuku = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setText("Daftar Buku Perpustakaan Java Valent");

        TabelBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Kategori"
            }
        ));
        jScrollPane1.setViewportView(TabelBuku);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblJudulBuku.setText("Judul Buku");

        txtJudulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulBukuActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(141, 141, 141)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCari))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJudulBuku)
                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnDelete))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new BerandaForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtJudulBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulBukuActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        String keyword = txtJudulBuku.getText().trim();
        if (!keyword.isEmpty()) {
            tampilkanDataBuku(keyword);
        } else {
            tampilkanDataBuku(); 
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
            int selectedRow = TabelBuku.getSelectedRow();
            if (selectedRow >= 0) {
                String judul = TabelBuku.getValueAt(selectedRow, 1).toString();
                String pengarang = TabelBuku.getValueAt(selectedRow, 2).toString();
                String TahunTerbit = TabelBuku.getValueAt(selectedRow, 4).toString();
                String Penerbit = TabelBuku.getValueAt(selectedRow, 3).toString();
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Apakah Anda yakin ingin menghapus buku \"" + judul + "\" oleh " + pengarang + "?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    controller.HapusBuku(Penerbit); 
                    tampilkanDataBuku(); 
                }
            }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(DaftarBukuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarBukuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarBukuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarBukuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BukuController controller = new BukuController();
                new DaftarBukuForm(controller).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelBuku;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJudulBuku;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtJudulBuku;
    // End of variables declaration//GEN-END:variables
}
