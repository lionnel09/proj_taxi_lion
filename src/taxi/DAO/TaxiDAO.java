/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Voiture;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Hp
 */
public class TaxiDAO extends DAO<Voiture> {

    /**
     * récupération des données d'un taxi sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idtaxi identifiant du taxi
     * @return taxi trouvé
     */
    @Override
    public Voiture read(int idtaxi) throws SQLException {
        String req = "select * from api_proj_taxi where idtaxi = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idtaxi);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String imma = rs.getString("IMMATRICULATION");
                    String carbu = rs.getString("CARBURANT");
                    Double p = rs.getDouble("PRIXKM");
                    String desc = rs.getString("DESCRIPTION");

                    return new Voiture(idtaxi, imma, carbu, p, desc);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * création d'un taxi sur base des valeurs de son objet classe
     *
     * @throws SQLException erreur de création
     * @param obj taxi à créer
     * @return taxi créé
     */
    @Override
    public Voiture create(Voiture obj) throws SQLException {
        String req1 = "insert into api_proj_taxi(immatriculation,carburant,prixkm,description) values(?,?,?,?)";
        String req2 = "select idtaxi from api_proj_taxi where immatriculation=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getImma());
            pstm1.setString(2, obj.getCarbu());
            pstm1.setDouble(3, obj.getPkm());
            pstm1.setString(4, obj.getDesc());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation du taxi, aucune ligne créée");
            }
            pstm2.setString(1, obj.getImma());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idtaxi = rs.getInt(1);
                    obj.setIdtaxi(idtaxi);
                    return read(idtaxi);
                } else {
                    throw new SQLException("erreur de création du taxi, record introuvable");
                }
            }
        }
    }

    /**
     * mise à jour des données du client sur base de son identifiant
     *
     * @return Taxi
     * @param obj Taxi à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Voiture update(Voiture obj) throws SQLException {
        String req = "update api_proj_taxi set immatriculation=?,carburant=?,prixkm=?,description=? where idtaxi=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(5, obj.getIdtaxi());
            pstm.setDouble(3, obj.getPkm());
            pstm.setString(1, obj.getImma());
            pstm.setString(2, obj.getCarbu());
            pstm.setString(4, obj.getDesc());
            
            int n = pstm.executeUpdate();
            
            if (n == 0) {
                throw new SQLException("aucune ligne taxi mise à jour");
            }
            return read(obj.getIdtaxi());
        }
    }

    /**
     * effacement du taxi sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj taxi à effacer
     */
    @Override
    public void delete(Voiture obj) throws SQLException {
        String req = "delete from api_proj_taxi where idtaxi= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdtaxi());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne taxi  effacée");
            }

        }
    }

    public Voiture rechimma(String imma) throws SQLException {
        String req = "select * from api_proj_taxi  where immatriculation = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, imma);
            boolean trouve = false;
            try (ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    trouve = true;
                    int idtaxi = rs.getInt("IDTAXI");
                    String carbu = rs.getString("CARBURANT");
                    Double pkm = rs.getDouble("PRIXKM");
                    String desc = rs.getString("DESCRIPTION");
                    Voiture vt = new Voiture(idtaxi, imma, carbu, pkm, desc);
                    if (!trouve) {
                        System.out.println("Taxi non trouvé");
                    } else {
                        return vt;
                    }
                }
            }

        }
        return null;

    }

    /**
     * méthode permettant de récupérer tous les taxi portant un certaine
     * description
     *
     * @param desc nom recherché
     * @return liste de clients
     * @throws SQLException nom inconnu
     */
    public List<Voiture> rechdesc(String desc) throws SQLException {
        List<Voiture> vtdesc = new ArrayList<>();
        String req = "select * from api_proj_taxi  where description like '%?%' ";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, desc);
            boolean trouve = false;
            try (ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    trouve = true;
                    int idtaxi = rs.getInt("IDTAXI");
                    String carbu = rs.getString("CARBURANT");
                    Double pkm = rs.getDouble("PRIXKM");
                    String imma = rs.getString("IMMATRICULATION");
                    vtdesc.add(new Voiture(idtaxi, imma, carbu, pkm, desc));
                   
                }
                 if (!trouve) {
                        System.out.println("Taxi non trouvé");
                    } else {
                        return vtdesc;
                    }
            }

        }
        return null;

    }

    public List<Voiture> aff() throws SQLException {
        List<Voiture> v = new ArrayList();
        String req = "select * from api_proj_taxi";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("IDTAXI");
                    String imma = rs.getString("IMMATRICULATION");
                    String carbu = rs.getString("CARBURANT");
                    Double pkm = rs.getDouble("PRIXKM");
                    String desc = rs.getString("DESCRIPTION");
                    v.add(new Voiture(id, imma, carbu, pkm, desc));
                }
            }
        }
        return v;
    }

}
