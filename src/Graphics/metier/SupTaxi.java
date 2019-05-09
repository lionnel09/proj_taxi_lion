/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.metier;

import classe.metier.Voiture;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import taxi.DAO.TaxiDAO;

/**
 *
 * @author Cloé Voitus
 */
public class SupTaxi extends javax.swing.JPanel {

    /**
     * Creates new form SupTaxi
     */
    TaxiDAO tx = null;
    DefaultTableModel dft1 = new DefaultTableModel();
    public SupTaxi() {
        initComponents();
        dft1.addColumn("idtaxi");
        dft1.addColumn("Immatriculation");
        dft1.addColumn("Carburant");
        dft1.addColumn("Prix au km");
        dft1.addColumn("Description");
        jTable1.setModel(dft1);
    }
    public void setTaxiDAO(TaxiDAO tx) {
        this.tx = tx;
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
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        crit = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Gill Sans Nova Ultra Bold", 1, 24)); // NOI18N
        jLabel1.setText("Taxi Voitus");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Gill Sans Nova Ultra Bold", 0, 10)); // NOI18N
        jLabel2.setText("Critère: ");

        crit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                critActionPerformed(evt);
            }
        });

        delete.setText("Supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jButton2.setText("Rechercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(237, 237, 237))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(106, 106, 106))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delete)
                                .addGap(86, 86, 86)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(crit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton2)))
                        .addGap(222, 222, 222))))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(jButton2))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void critActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_critActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_critActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            String critr = crit.getText();
            List<Voiture> alc = tx.aff();
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (Voiture vt : alc) {
                Vector v = new Vector();
                v.add(vt.getIdtaxi());
                v.add(vt.getImma());
                v.add(vt.getCarbu());
                v.add(vt.getPkm());
                v.add(vt.getDesc());
                dft1.addRow(v);
            }
            tx.delete(critr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String critr = crit.getText();
            List<Voiture> alc = tx.aff();
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (Voiture vt : alc) {
                Vector v = new Vector();
                v.add(vt.getIdtaxi());
                v.add(vt.getImma());
                v.add(vt.getCarbu());
                v.add(vt.getPkm());
                v.add(vt.getDesc());
                dft1.addRow(v);
            }
            tx.rechdesc(critr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField crit;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}