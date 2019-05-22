/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.metier;

import classe.metier.Adresse;
import classe.metier.Client;
import classe.metier.Location;
import classe.metier.Voiture;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import taxi.DAO.AdresseDAO;
import taxi.DAO.ClientDAO;
import taxi.DAO.LocationDAO;
import taxi.DAO.TaxiDAO;

/**
 *
 * @author lionn
 */
public final class CreaLoc extends javax.swing.JPanel {

    /**
     * Creates new form Crea
     */
    ClientDAO clientDAO = null;
    AdresseDAO adresseDAO = null;
    LocationDAO locationDAO = null;
    TaxiDAO taxiDAO = null;
    DefaultComboBoxModel dlmcl = new DefaultComboBoxModel();
    DefaultComboBoxModel dlmtx = new DefaultComboBoxModel();
    DefaultComboBoxModel dlmadrdeb = new DefaultComboBoxModel();
    DefaultComboBoxModel dlmadrfin = new DefaultComboBoxModel();
    List<Adresse> afl;
    List<Adresse> afl1;
    List<Voiture> vtl;
    List<Client> cll;

    public CreaLoc() {
        initComponents();

    }

    public void setAdresseDAO(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void setTaxiDAO(TaxiDAO taxiDAO) {
        this.taxiDAO = taxiDAO;
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    public void inject_Client() {
        try {
            cll = clientDAO.aff();
            if (cl != null) {
                cl.removeAllItems();
            }

            Iterator<Client> itc = cll.iterator();
            while (itc.hasNext()) {
                Client c = itc.next();
                dlmcl.addElement(c.toString());
            }
            /*for (int i = 0; i < cll.size(); i++) {
                dlmcl.addElement(cll.get(i).toString());

            }*/
            cl.setModel(dlmcl);

        } catch (SQLException e) {
            System.out.println("Exception" + e);
        }
    }

    public void inject_taxi() {
        try {
            vtl = taxiDAO.aff();
            if (taxi != null) {
                taxi.removeAllItems();
            }
            Iterator<Voiture> itt = vtl.iterator();
            while (itt.hasNext()) {
                Voiture v = itt.next();
                dlmtx.addElement(v.toString());
            }
            /*for (int i = 0; i < vtl.size(); i++) {
                dlmtx.addElement(vtl.get(i).toString());

            }*/
            taxi.setModel(dlmtx);

        } catch (SQLException e) {
            System.out.println("Exception" + e);
        }
    }

    public void inject_adr() {
        try {
            afl = adresseDAO.aff();
            afl1 = adresseDAO.aff();
            if (adrdeb != null) {
                adrdeb.removeAllItems();
                adrfin.removeAllItems();
            }

            Iterator<Adresse> ita = afl.iterator();
            Iterator<Adresse> ita1 = afl1.iterator();

            /*for (int i = 0; i < afl.size(); i++) {
                dlmadrdeb.addElement(afl.get(i).toString());
                dlmadrfin.addElement(afl1.get(i).toString());
            }*/
            while (ita.hasNext()) {
                Adresse a = ita.next();
                Adresse a1 = ita1.next();
                dlmadrdeb.addElement(a.toString());
                dlmadrfin.addElement(a1.toString());

            }
            adrdeb.setModel(dlmadrdeb);
            adrfin.setModel(dlmadrfin);

        } catch (SQLException e) {
            System.out.println("Exception" + e);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        km = new javax.swing.JTextField();
        acmpt = new javax.swing.JTextField();
        tot = new javax.swing.JTextField();
        cl = new javax.swing.JComboBox<>();
        taxi = new javax.swing.JComboBox<>();
        adrdeb = new javax.swing.JComboBox<>();
        adrfin = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        dt = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(1298, 619));

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel1.setText("Date : ");

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel2.setText("Km Total :");

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel3.setText("Acompte :");

        jLabel4.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel4.setText("Total :");

        jLabel5.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel5.setText("Client :");

        jLabel6.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel6.setText("Taxi :");

        jLabel7.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel7.setText("Adresse Départ :");

        jLabel8.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel8.setText("Adresse d'arrivée :");

        tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totActionPerformed(evt);
            }
        });

        cl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clActionPerformed(evt);
            }
        });

        taxi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        adrdeb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        adrfin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel9.setText("Taxi Voitus");

        try {
            dt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(adrdeb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(taxi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cl, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(km, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acmpt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adrfin, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)))
                .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel9)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(acmpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(taxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(adrdeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(adrfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            String datedeb = dt.getText();
            int jourd = Integer.parseInt(datedeb.substring(0, 2));
            int moisd = Integer.parseInt(datedeb.substring(3, 5));
            int and = Integer.parseInt(datedeb.substring(6));

            LocalDate date = LocalDate.of(and, moisd, jourd);

            Double ktotal = Double.parseDouble(km.getText());
            Double acompte = Double.parseDouble(acmpt.getText());
            Double total = Double.parseDouble(tot.getText());
            int fkcl = cl.getSelectedIndex();
            Client client = cll.get(fkcl);
            int fktx = taxi.getSelectedIndex();
            Voiture voiture = vtl.get(fktx);
            int fkadrdeb = adrdeb.getSelectedIndex();
            Adresse adressed = afl.get(fkadrdeb);
            int fkadrfin = adrfin.getSelectedIndex();
            Adresse adressef = afl1.get(fkadrfin);
            Location l = new Location(0, date, ktotal, acompte, total, client.getIdclient(), voiture.getIdtaxi(), adressed.getIdadr(), adressef.getIdadr());

            locationDAO.create(l);
            inject_taxi();
            inject_adr();
            inject_Client();
            JOptionPane.showMessageDialog(this, "Location créé", "Succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totActionPerformed

    private void clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acmpt;
    private javax.swing.JComboBox<String> adrdeb;
    private javax.swing.JComboBox<String> adrfin;
    private javax.swing.JComboBox<String> cl;
    private javax.swing.JFormattedTextField dt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField km;
    private javax.swing.JComboBox<String> taxi;
    private javax.swing.JTextField tot;
    // End of variables declaration//GEN-END:variables
}
