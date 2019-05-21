/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.metier;

import classe.metier.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import taxi.DAO.AdresseDAO;
import taxi.DAO.ClientDAO;
import taxi.DAO.LocationDAO;
import taxi.DAO.TaxiDAO;

/**
 *
 * @author lionn
 */
public class Maj_Adr extends javax.swing.JPanel {

    /**
     * Creates new form Maj_Adr
     */
    ClientDAO clientDAO = null;
    AdresseDAO adresseDAO = null;
    LocationDAO locationDAO = null;
    TaxiDAO taxiDAO = null;
    DefaultComboBoxModel dlmcl = new DefaultComboBoxModel();
    DefaultComboBoxModel dlmtx = new DefaultComboBoxModel();
    DefaultComboBoxModel dlmadrdeb = new DefaultComboBoxModel();
    DefaultComboBoxModel dlmadrfin = new DefaultComboBoxModel();
    DefaultComboBoxModel dlmloc = new DefaultComboBoxModel();
    List<Location> loc;
    List<Adresse> afl;
    List<Adresse> afl1;
    List<Voiture> vtl;
    List<Client> cll;
    DefaultTableModel dft1 = new DefaultTableModel();

    public Maj_Adr() {
        initComponents();
        dft1.addColumn("idloc");
        dft1.addColumn("DateLoc");
        dft1.addColumn("Kmtotal");
        dft1.addColumn("acompte");
        dft1.addColumn("total");
        dft1.addColumn("taxi");
        dft1.addColumn("client");
        dft1.addColumn("adresse de départ");
        dft1.addColumn("adresse de fin");
        locatab.setModel(dft1);

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
            if (cli != null) {
                cli.removeAllItems();
            }
            Iterator<Client> itc = cll.iterator();
            while (itc.hasNext()) {
                Client c = itc.next();
                dlmcl.addElement(c.toString());
            }
            /*for (int i = 0; i < cll.size(); i++) {
                dlmcl.addElement(cll.get(i).toString());

            }*/
            cli.setModel(dlmcl);

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

    public void inject_loc() {
        try {

            loc = locationDAO.aff();
            if (locat != null) {
                locat.removeAllItems();
            }
            Iterator<Location> itl = loc.iterator();
            while (itl.hasNext()) {
                Location l = itl.next();
                dlmloc.addElement(l.toString());
            }
            /*for (int i = 0; i < loc.size(); i++) {
                dlmloc.addElement(loc.get(i).toString());
            }*/
            locat.setModel(dlmloc);

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

        acmpt = new javax.swing.JTextField();
        tot = new javax.swing.JTextField();
        cli = new javax.swing.JComboBox<>();
        taxi = new javax.swing.JComboBox<>();
        adrdeb = new javax.swing.JComboBox<>();
        adrfin = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        dt = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        km = new javax.swing.JTextField();
        locat = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        maj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        locatab = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totActionPerformed(evt);
            }
        });

        cli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliActionPerformed(evt);
            }
        });

        taxi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        adrdeb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        adrfin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        jButton1.setText("supprimer");
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

        locat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel10.setText("Location");

        maj.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        maj.setText("Mettre à jour");
        maj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majActionPerformed(evt);
            }
        });

        locatab.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(locatab);

        jButton2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        jButton2.setText("Toutes les Locations");
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
                .addGap(539, 539, 539)
                .addComponent(jLabel9)
                .addGap(486, 486, 486))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jButton1))
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(maj, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addComponent(jButton2)
                        .addContainerGap(458, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acmpt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(km, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cli, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taxi, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adrdeb, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adrfin, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locat, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(taxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(adrdeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(adrfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(locat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maj, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addGap(69, 69, 69))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totActionPerformed

    private void cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            int fkloc = locat.getSelectedIndex();
            Location l = loc.get(fkloc);
            locationDAO.delete(l);
            inject_taxi();
            inject_adr();
            inject_Client();
            inject_loc();
            JOptionPane.showMessageDialog(this, "Location mise à jour", "Succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void majActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majActionPerformed

        try {

            String datedeb = dt.getText();
            int jourd = Integer.parseInt(datedeb.substring(0, 2));
            int moisd = Integer.parseInt(datedeb.substring(3, 5));

            int and = Integer.parseInt(datedeb.substring(6));

            LocalDate date = LocalDate.of(and, moisd, jourd);

            Double ktotal = Double.parseDouble(km.getText());
            Double acompte = Double.parseDouble(acmpt.getText());
            Double total = Double.parseDouble(tot.getText());
            int fkcl = cli.getSelectedIndex();
            Client client = cll.get(fkcl);
            int fktx = taxi.getSelectedIndex();
            Voiture voiture = vtl.get(fktx);
            int fkadrdeb = adrdeb.getSelectedIndex();
            Adresse adressed = afl.get(fkadrdeb);
            int fkadrfin = adrfin.getSelectedIndex();
            Adresse adressef = afl1.get(fkadrfin);
            int idl = locat.getSelectedIndex();
            Location id = loc.get(idl);
            Location l = new Location(id.getIdloc(), date, ktotal, acompte, total, client.getIdclient(), voiture.getIdtaxi(), adressed.getIdadr(), adressef.getIdadr());
            System.out.println(l);
            locationDAO.update(l);
            inject_taxi();
            inject_adr();
            inject_Client();
            inject_loc();
            JOptionPane.showMessageDialog(this, "Location mise à jour", "Succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_majActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            List<Location> locl = locationDAO.aff();
            System.out.println(locl);
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }

            for (Location l : locl) {
                Vector v = new Vector();
                v.add(l.getIdloc());
                v.add(l.getDateloc());
                v.add(l.getKmtotal());
                v.add(l.getAcompte());
                v.add(l.getTotal());
                Voiture t = taxiDAO.read(l.getFktaxi());
                v.add(t.getImma());
                Client c = clientDAO.read(l.getFkclient());
                v.add(c.getNom());
                Adresse ad = adresseDAO.read(l.getIdadr_deb());
                Adresse af = adresseDAO.read(l.getIdadr_fin());
                v.add(ad.getNum() + ",Rue " + ad.getRue() + " " + ad.getLocalite());
                v.add(af.getNum() + ",Rue" + af.getRue() + " " + af.getLocalite());
                System.out.println(v);
                dft1.addRow(v);
            }
        } catch (SQLException e) {
            System.out.println("Exception " + e);
        }


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acmpt;
    private javax.swing.JComboBox<String> adrdeb;
    private javax.swing.JComboBox<String> adrfin;
    private javax.swing.JComboBox<String> cli;
    private javax.swing.JFormattedTextField dt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField km;
    private javax.swing.JComboBox<String> locat;
    private javax.swing.JTable locatab;
    private javax.swing.JButton maj;
    private javax.swing.JComboBox<String> taxi;
    private javax.swing.JTextField tot;
    // End of variables declaration//GEN-END:variables
}
