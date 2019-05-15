/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiDAO.Metier.Builder;

import java.sql.SQLException;

/**
 *
 * @author lionn
 */
public class Main {

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Création du taxi1");
            Voiture vt = new Voiture.Taxibuilder().
                    setIdtaxi(1).
                    setImma("fk22").
                    setCarbu("Essence").
                    setPkm(12.5).
                    setDesc("Belle beauté").
                    build();
            System.out.println(vt);
        } catch (Exception e) {

            System.out.println("erreur " + e);
        }
        try {
            System.out.println("Création du taxi2");
            Voiture vt2 = new Voiture.Taxibuilder().
                    setIdtaxi(1).
                    setImma("").
                    setCarbu("Essence").
                    setPkm(0.0).
                    setDesc("Belle beauté").
                    build();
            System.out.println(vt2);
        } catch (Exception e) {
            System.out.println("erreur " + e);
        }

    }
}
