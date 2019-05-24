/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiDAO.Metier.Observer;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author hp
 */
public class main {
    public static void main(String[] args) {
        
        Voiture vt=new Voiture(1,"AB1","Fuel",23.5,"essaie pour un taxi de location");
        Adresse adrdepart=new Adresse(1,7000,"mons","rue saint-paul","5");
        Adresse adrarrive=new Adresse(4,7000,"mons","rue dutrieux","7");
        Client cl=new Client(1,"lionnel","boglis","04652658",adrdepart);
        adrdepart.getClient().add(cl);
        Location loc=new Location(1,LocalDate.of(2019, Month.DECEMBER, 20),Double.parseDouble("23.5"),Double.parseDouble("40"),Double.parseDouble("314"),cl,vt,adrdepart,adrarrive);
        
        vt.getMesLocations().add(loc);
        adrdepart.getLocdeb().add(loc);
        adrarrive.getLocfin().add(loc);
        Voiture vt2=new Voiture(1,"AG1","Fuel",2.5,"essaie pour un taxi 2 de location");
        loc.setFktaxi(vt2);
    }
}
