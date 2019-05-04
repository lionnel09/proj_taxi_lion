package taxi_proj;

import classe.metier.Location;
import taxi.DAO.TaxiDAO;
import taxi.DAO.DAO;
import classe.metier.Voiture;
import connect.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import taxi.DAO.LocationDAO;

public class Taxi_proj {

    Scanner sc = new Scanner(System.in);
    //Instanciation de la variable globale vt de la classe 
    Voiture vt = null;
    Location loc = null;
    //Instanciation de la variable globale tx de la classe DAO
    DAO<Voiture> tx = null;
    DAO<Location> lct = null;
//Constructeur par défaut 

    public Taxi_proj() {
    }
//Menu gestion de la tables taxi

    public void gestion() {
        //Connexion à la base de données 
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
        System.out.println("connexion établie");

        tx = new TaxiDAO();

        tx.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("1.nouveau taxi\n2.recherche sur l'immatriculation  du taxi\n3.modification d'une voiture \n4.supprimer un taxi \n5.recherche sur la description \n6.afficher les taxis dispo\n7.Total à payer \n8.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    nouveau();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modif();
                    break;
                case 4:
                    sup();
                    break;
                case 5:
                    rechdesc();
                    break;
                case 6:
                    affiche();
                    break;
                case 7:
                    afftotal();
                    break;
                case 8:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 8);
        DBConnection.closeConnection();
    }
// Encodage d'un nouvea Taxi dans la base  de données /////

    public void nouveau() {
        System.out.println("immatriculation : ");
        String imma = sc.nextLine();
        System.out.println("Carburant :");
        String carbu = sc.nextLine();
        System.out.println("Prix au Km :");
        Double pkm = sc.nextDouble();
        sc.skip("\n");
        System.out.println("description : ");
        String desc = sc.nextLine();
        vt = new Voiture(imma, carbu, pkm, desc);
        try {
            vt = tx.create(vt);
            System.out.println("information du taxi encodé : " + vt);
        } catch (SQLException e) {
            System.out.println("erreur : " + e);
        }
    }
// Recherche sur base de l'immatriculation 

    public void recherche() {
        try {
            System.out.println("immatriculation du véhicule :  ");
            String imma = sc.nextLine();
            vt = ((TaxiDAO) tx).rechimma(imma);
            System.out.println("Resultat de la recherche : " + vt);
        } catch (SQLException e) {
            System.out.println("erreur : " + e);
        }
    }
//Modification d'un véhicule encodé

    public void modif() {

        try {
            System.out.println("carburant  :");
            String carbu = sc.next();
            vt.setCarbu(carbu);
            tx.update(vt);

        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
    }
// Affichage du véhiculesdisponibles 

    public void affiche() {
        try {
            List<Voiture> v = ((TaxiDAO) tx).aff();
            for (int i = 0; i < v.size(); i++) {
                System.out.println("\n" + v.get(i).toString());
            }
        } catch (SQLException e) {
            System.out.println("erreur : " + e);
        }
    }
//Suppression d'un taxi déjà encoder 

    public void sup() {
        try {
            tx.delete(vt);
        } catch (SQLException e) {
            System.out.println("erreur :" + e.getMessage());
        }
    }
//Recherche sur base de la description 

    public void rechdesc() {
        System.out.println("description du véhicule  :  ");
        String desc = sc.nextLine();
        try {
            List<Voiture> v = ((TaxiDAO) tx).rechdesc(desc);
            for (Voiture cl : v) {
                System.out.println(cl);
            }
            System.out.println("Resultat de la recherche : " + vt);
        } catch (SQLException e) {
            System.out.println("erreur : " + e);
        }

    }

    public void afftotal() {
        System.out.println("Entrer l'identifiant : ");
        int crit = sc.nextInt();
        try {
            Double result = ((LocationDAO) lct).aff(crit);
            System.out.println("" + result);
        } catch (SQLException e) {
            System.out.println("erreur " + e);
        }
    }

//Fonction main principal 
    public static void main(String[] args) throws SQLException {

        Taxi_proj tp = new Taxi_proj();
        tp.gestion();
    }

}
