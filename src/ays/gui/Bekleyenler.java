/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ays.gui;

import ays.database.ArizaKaydiIslemleri;
import ays.database.VeritabaniBaglantiYoneticisi;
import ays.modeller.ArizaKaydi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author begum.celebi
 */
public class Bekleyenler extends javax.swing.JFrame {

    ArizaKaydiIslemleri arizaKaydiIslemleri = null;

    /**
     * Creates new form Bekleyenler
     */
    public Bekleyenler() {
        initComponents();
        Dimension dim;
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
        arizaKaydiIslemleri = new ArizaKaydiIslemleri();

        ArrayList<ArizaKaydi> bekleyenler = arizaKaydiIslemleri.BekleyenKayitleriGetir();
        int sutunSayisi = bekleyenler.size();

        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("AKNO");
        table.addColumn("Bölüm");
        table.addColumn("Hat");
        table.addColumn("Makina");
        table.addColumn("Arıza");
        table.addColumn("Başlangıç");
        table.addColumn("Bitiş");
        table.addColumn("Kategori");
        table.addColumn("Teknisyen");
        table.addColumn("Bildiren");
        table.addColumn("İşlem");

        for (ArizaKaydi arizaKaydi : bekleyenler) {
            Object[] row = new Object[11];
            row[0] = arizaKaydi.getAkno();
            row[1] = arizaKaydi.getBolum();
            row[2] = arizaKaydi.getHat();
            row[3] = arizaKaydi.getMakina();
            row[4] = arizaKaydi.getAriza();
            row[5] = arizaKaydi.getBaslangic();
            row[6] = arizaKaydi.getBitis();
            row[7] = arizaKaydi.getKategori();
            row[8] = arizaKaydi.getTeknisyen();
            row[9] = arizaKaydi.getOlusturan_sicilno();
            row[10] = arizaKaydi.getIslem();

            table.addRow(row);
        }

        bekleyenTablo.setModel(table);
        int satirSayisi = bekleyenTablo.getRowCount();
        toplamKayitLabel.setText(String.valueOf(satirSayisi));

        if (GirisYapmisKullanici.kullanici.getSicilNo().equals("0")) {
            teknisyenAtaButon.setVisible(false);
        }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        bekleyenTablo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        sonucGosterComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        geriButon = new javax.swing.JButton();
        teknisyenAtaButon = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        toplamKayitLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bekleyen Arıza Bildirimleri");

        bekleyenTablo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        bekleyenTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        bekleyenTablo.setEditingColumn(50);
        bekleyenTablo.setEditingRow(50);
        jScrollPane1.setViewportView(bekleyenTablo);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Son");

        sonucGosterComboBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sonucGosterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "25", "50" }));
        sonucGosterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sonucGosterComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("göster");

        geriButon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        geriButon.setText("GERİ");
        geriButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriButonActionPerformed(evt);
            }
        });

        teknisyenAtaButon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        teknisyenAtaButon.setText("Teknisyen");
        teknisyenAtaButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teknisyenAtaButonActionPerformed(evt);
            }
        });

        jLabel4.setText("Toplam kayıt:");

        toplamKayitLabel.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sonucGosterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addContainerGap(1085, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(geriButon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toplamKayitLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teknisyenAtaButon)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(geriButon)))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sonucGosterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(toplamKayitLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(teknisyenAtaButon)))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sonucGosterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sonucGosterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sonucGosterComboBoxActionPerformed

    private void geriButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriButonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Anasayfa giris = new Anasayfa();
        giris.setVisible(true);
    }//GEN-LAST:event_geriButonActionPerformed

    private void teknisyenAtaButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teknisyenAtaButonActionPerformed
        Connection baglanti;
        int row = bekleyenTablo.getSelectedRow();

        if (row == -1) // seçilmemişse
        {
            JOptionPane.showMessageDialog(null, "Arıza seçin.", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //   String Table_click = (bekleyenTablo.getModel().getValueAt(row, 0).toString());
            int secim = JOptionPane.showConfirmDialog(null, "Arıza kaydını üstünüze almak istiyor musunuz?", " ", JOptionPane.YES_NO_OPTION);

            try {
                baglanti = VeritabaniBaglantiYoneticisi.getConnection();
                Statement sorgu;
                sorgu = baglanti.createStatement();
                if (secim == 0) {  // yes = 0   no= 1
                    JOptionPane.showMessageDialog(null, "Arıza kaydı atandı", "", JOptionPane.INFORMATION_MESSAGE);

                    String sicilNo = GirisYapmisKullanici.kullanici.getSicilNo();
                    String arizaID = bekleyenTablo.getValueAt(bekleyenTablo.getSelectedRow(), 0).toString();
                    sorgu.executeUpdate("UPDATE ariza_kaydi SET teknisyen = " + "'" + sicilNo + "'" + "WHERE akno = " + arizaID + "");
                    // System.out.println(arizaID);
                }

            } catch (SQLException ex) {
                Logger.getLogger(YeniArızaKaydı.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_teknisyenAtaButonActionPerformed

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
            java.util.logging.Logger.getLogger(Bekleyenler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bekleyenler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bekleyenler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bekleyenler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bekleyenler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bekleyenTablo;
    private javax.swing.JButton geriButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> sonucGosterComboBox;
    private javax.swing.JButton teknisyenAtaButon;
    private javax.swing.JLabel toplamKayitLabel;
    // End of variables declaration//GEN-END:variables

}
