package Graphics.metier;

import classe.metier.Adresse;
import connect.DBConnection;
import taxi_proj.Taxi_proj;
import java.*;
import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import taxi.DAO.AdresseDAO;
import taxi.DAO.ClientDAO;
import taxi.DAO.LocationDAO;
import taxi.DAO.TaxiDAO;

/**
 *
 * @author Hp
 */
public class Gestion extends javax.swing.JFrame {

    /**
     * Creates new form Gestion
     */
    CardLayout cardl;

    public Gestion() {
        initComponents();
        cardl = (CardLayout) this.getContentPane().getLayout();
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            JOptionPane.showMessageDialog(this, "connexion invalide", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
        TaxiDAO taxiDAO = new TaxiDAO();
        AdresseDAO adresseDAO = new AdresseDAO();
        ClientDAO clientDAO = new ClientDAO();
        LocationDAO locationDAO = new LocationDAO();
        locationDAO.setConnection(dbConnect);
        adresseDAO.setConnection(dbConnect);
        clientDAO.setConnection(dbConnect);
        taxiDAO.setConnection(dbConnect);
        creaTaxi.setTaxiDAO(taxiDAO);
        supTaxi.setTaxiDAO(taxiDAO);
        maj.setTaxiDAO(taxiDAO);
        creaAdr.setAdresseDAO(adresseDAO);
        creaCli.setAdresseDAO(adresseDAO);
        creaCli.setClientDAO(clientDAO);
        creaCli.inject_adr();
        creaLoc.setAdresseDAO(adresseDAO);
        creaLoc.setClientDAO(clientDAO);
        creaLoc.setLocationDAO(locationDAO);
        creaLoc.setTaxiDAO(taxiDAO);
        creaLoc.inject_adr();
        creaLoc.inject_taxi();
        creaLoc.inject_Client();
        maj_Adr.setLocationDAO(locationDAO);
        maj_Adr.setAdresseDAO(adresseDAO);
        maj_Adr.setTaxiDAO(taxiDAO);
        maj_Adr.setClientDAO(clientDAO);
        maj_Adr.inject_adr();
        maj_Adr.inject_Client();
        maj_Adr.inject_loc();
        maj_Adr.inject_taxi();
        trouve_loc.setLocationDAO(locationDAO);
        trouve_loc.setTaxiDAO(taxiDAO);
        trouve_loc.setAdresseDAO(adresseDAO);
        trouve_loc.setClientDAO(clientDAO);
        trouve_loc.inject_taxi();
        maj_cli.setAdresseDAO(adresseDAO);
        maj_cli.setClientDAO(clientDAO);
        maj_cli.inject_Client();
        maj_cli.inject_adr();
        gestion_adr.setAdresseDAO(adresseDAO);
        gestion_adr.inject_adr();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jMenuItem1 = new javax.swing.JMenuItem();
        creaTaxi = new Graphics.metier.CreaTaxi();
        supTaxi = new Graphics.metier.SupTaxi();
        maj = new Graphics.metier.Maj();
        creaAdr = new Graphics.metier.CreaAdr();
        creaCli = new Graphics.metier.CreaCli();
        creaLoc = new Graphics.metier.CreaLoc();
        trouve_loc = new Graphics.metier.Trouve_loc();
        maj_Adr = new Graphics.metier.Maj_Adr();
        maj_cli = new Graphics.metier.Maj_cli();
        gestion_adr = new Graphics.metier.Gestion_adr();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu2ActionPerformed(evt);
            }
        });
        menuBar1.add(menu2);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(creaTaxi, "cardCrea");
        getContentPane().add(supTaxi, "cardSup");
        getContentPane().add(maj, "cardupdate");
        getContentPane().add(creaAdr, "cardCreaAdr");
        getContentPane().add(creaCli, "cardCreaCli");
        getContentPane().add(creaLoc, "cardcrealoc");
        getContentPane().add(trouve_loc, "cardtrouveloc");
        getContentPane().add(maj_Adr, "cardmaj_adr");
        getContentPane().add(maj_cli, "cardmajcli");
        getContentPane().add(gestion_adr, "cardgest");

        jMenu1.setText("Taxi");

        jMenuItem2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 12)); // NOI18N
        jMenuItem2.setText("Creation de Taxi");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 12)); // NOI18N
        jMenuItem3.setText("Gestion Taxi");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 12)); // NOI18N
        jMenuItem4.setText("Mise à Jour");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem9.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 12)); // NOI18N
        jMenuItem9.setText("Location");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Location");

        jMenuItem5.setText("Ajouter");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem8.setText("gestion location");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Adresse");

        jMenuItem7.setText("Ajouter");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem11.setText("Gestion Adresse");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Client");

        jMenuItem6.setText("Ajouter");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem10.setText("Gestion Client");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        cardl.show(this.getContentPane(), "cardCrea");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        cardl.show(this.getContentPane(), "cardSup");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        cardl.show(this.getContentPane(), "cardupdate");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        creaLoc.inject_adr();
        creaLoc.inject_taxi();
        creaLoc.inject_Client();
        cardl.show(this.getContentPane(), "cardcrealoc");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        creaCli.inject_adr();
        cardl.show(this.getContentPane(), "cardCreaCli");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        cardl.show(this.getContentPane(), "cardCreaAdr");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        cardl.show(this.getContentPane(), "cardmaj_adr");
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        trouve_loc.inject_taxi();
        cardl.show(this.getContentPane(), "cardtrouveloc");
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        maj_cli.inject_Client();
        maj_cli.inject_adr();
        cardl.show(this.getContentPane(), "cardmajcli");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        gestion_adr.inject_adr();
        cardl.show(this.getContentPane(), "cardgest");
    }//GEN-LAST:event_jMenuItem11ActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Graphics.metier.CreaAdr creaAdr;
    private Graphics.metier.CreaCli creaCli;
    private Graphics.metier.CreaLoc creaLoc;
    private Graphics.metier.CreaTaxi creaTaxi;
    private Graphics.metier.Gestion_adr gestion_adr;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private Graphics.metier.Maj maj;
    private Graphics.metier.Maj_Adr maj_Adr;
    private Graphics.metier.Maj_cli maj_cli;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private Graphics.metier.SupTaxi supTaxi;
    private Graphics.metier.Trouve_loc trouve_loc;
    // End of variables declaration//GEN-END:variables
}
