/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Location;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp
 */
public class LocationDAO extends DAO<Location> {

    /**
     * récupération des données d'une location sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idloc identifiant de la location
     * @return location trouvé
     */
    @Override
    public Location read(int idloc) throws SQLException {
        String req = "select * from api_proj_location where idloc = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idloc);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    LocalDate date = rs.getDate("DATELOC").toLocalDate();
                    Double kmtotal = rs.getDouble("KMTOTAL");
                    Double acompte = rs.getDouble("ACOMPTE");
                    Double total = rs.getDouble("TOTAL");
                    int idclient = rs.getInt("IDCLIENT");
                    int idtaxi = rs.getInt("IDTAXI");
                    int idadr_deb = rs.getInt("IDADR_DEB");
                    int idadr_fin = rs.getInt("IDADR_FIN");

                    return new Location(idloc, date, kmtotal, acompte, total, idclient, idtaxi, idadr_deb, idadr_fin);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * création d'une location sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj location à créer
     * @return location créé
     */
    @Override
    public Location create(Location obj) throws SQLException {
        String req1 = "insert into api_proj_location (dateloc,kmtotal,acompte,total,idclient,idtaxi,idadr_deb,idadr_fin) values(?,?,?,?,?,?,?,?)";
        String req2 = "select idloc from api_proj_location where dateloc=? and kmtotal=? and acompte=? and total=? and idclient=? and idtaxi=? and idadr_deb=? and idadr_fin=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm1.setDouble(2, obj.getKmtotal());
            pstm1.setDouble(3, obj.getAcompte());
            pstm1.setDouble(4, obj.getTotal());

            pstm1.setInt(5, obj.getFkclient());
            pstm1.setInt(6, obj.getFktaxi());
            pstm1.setInt(7, obj.getIdadr_deb());
            pstm1.setInt(8, obj.getIdadr_fin());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation location, aucune ligne créée");
            }
            pstm2.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm2.setDouble(2, obj.getKmtotal());
            pstm2.setDouble(3, obj.getAcompte());
            pstm2.setDouble(4, obj.getTotal());

            pstm2.setInt(5, obj.getFkclient());
            pstm2.setInt(6, obj.getFktaxi());
            pstm2.setInt(7, obj.getIdadr_deb());
            pstm2.setInt(8, obj.getIdadr_fin());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idloc = rs.getInt(1);
                    obj.setIdloc(idloc);
                    return read(idloc);
                } else {
                    throw new SQLException("erreur de création location, record introuvable");
                }
            }
        }
    }

    /**
     * mise à jour des données de la location sur base de son identifiant
     *
     * @return Location
     * @param obj location à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Location update(Location obj) throws SQLException {
        String req = "update api_proj_location set dateloc=?,kmtotal=?,acompte=?,total=?,idclient=?,idtaxi=?,idadr_deb=?,idadr_fin=? where idloc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(8, obj.getIdloc());
            pstm.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm.setDouble(2, obj.getKmtotal());
            pstm.setDouble(3, obj.getAcompte());
            pstm.setDouble(4, obj.getTotal());
            pstm.setInt(5, obj.getFkclient());
            pstm.setInt(6, obj.getFktaxi());
            pstm.setInt(7, obj.getIdadr_deb());
            pstm.setInt(8, obj.getIdadr_fin());
            System.out.println(req);
            int n = pstm.executeUpdate();
            System.out.println(req);
            if (n == 0) {
                throw new SQLException("aucune ligne location mise à jour");
            }
            return read(obj.getIdloc());
        }
    }

    /**
     * effacement de la location sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj location à effacer
     */
    @Override
    public void delete(Location obj) throws SQLException {
        String req = "delete from api_proj_location where idloc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdloc());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne location effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer la date de la dernière commande d'un
     * client
     *
     * @param idloc identifiant recherché
     * @return total de la location
     * @throws SQLException location sans commande
     */
    public Double aff(int idloc) throws SQLException {

        Double tot = null;
        String req = "select * from total_paid where idloc=?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idloc);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    tot = rs.getDouble("total");
                    System.out.println("" + tot);
                    return tot;
                } else {
                    throw new SQLException("Aucune location n'a cet id ");
                }
            }
        }

    }

    public List<Location> aff() throws SQLException {
        List<Location> l = new ArrayList();
        String req = "select * from api_proj_location";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int idloc = rs.getInt("IDLOC");
                    LocalDate date = rs.getDate("DATELOC").toLocalDate();
                    Double kmtotal = rs.getDouble("KMTOTAL");
                    Double acompte = rs.getDouble("ACOMPTE");
                    Double total = rs.getDouble("TOTAL");
                    int idclient = rs.getInt("IDCLIENT");
                    int idtaxi = rs.getInt("IDTAXI");
                    int idadr_deb = rs.getInt("IDADR_DEB");
                    int idadr_fin = rs.getInt("IDADR_FIN");
                    l.add(new Location(idloc, date, kmtotal, acompte, total, idclient, idtaxi, idadr_deb, idadr_fin));
                }
            }
        }
        return l;
    }

}
