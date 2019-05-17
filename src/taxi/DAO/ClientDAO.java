/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp
 */
public class ClientDAO extends DAO<Client> {

    @Override
    public Client read(int idclient) throws SQLException {
      String req = "select * from api_proj_client where idclient = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idclient);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    
                    String tel = rs.getString("TEL");
                    int idadr=rs.getInt("IDADR");
                    return new Client(idclient, nom, prenom, tel,idadr);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    @Override
    public Client create(Client obj) throws SQLException {
         String req1 = "insert into api_proj_client(nom,prenom,tel,idadr) values(?,?,?,?)";
        String req2 = "select idclient from api_proj_client where nom=? and prenom=? and tel=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getNom());
            pstm1.setString(2, obj.getPrenom());
            pstm1.setString(3, obj.getTel());
            pstm1.setInt(4, obj.getIdadr());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation client, aucune ligne créée");
            }
            pstm2.setString(1, obj.getNom());
            pstm2.setString(2, obj.getPrenom());
            pstm2.setString(3, obj.getTel());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idclient = rs.getInt(1);
                    obj.setIdclient(idclient);
                    return read(idclient);
                } else {
                    throw new SQLException("erreur de création client, record introuvable");
                }
            }
        }
    }

    @Override
    public Client update(Client obj) throws SQLException {
         String req = "update api_proj_client set nom=?,prenom=?,tel=?,idadr=? where idclient= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(5, obj.getIdclient());
            pstm.setString(1, obj.getNom());
            pstm.setString(2, obj.getPrenom());
            pstm.setInt(4, obj.getIdadr());
            pstm.setString(3, obj.getTel());
            System.out.println(req);
            int n = pstm.executeUpdate();
            System.out.println(req);
            if (n == 0) {
                throw new SQLException("aucune ligne client mise à jour");
            }
            return read(obj.getIdclient());
        }
    }

    @Override
    public void delete(Client obj) throws SQLException {
        String req = "delete from api_proj_client where idclient= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdclient());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne client effacée");
            }

        }
    }
    public List<Client> aff() throws SQLException{
        List<Client> c = new ArrayList();
        String req = "select * from api_proj_client";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("IDCLIENT");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String tel = rs.getString("TEL");
                    int adr = rs.getInt("IDADR");
                    c.add(new Client(id, nom, prenom, tel, adr));
                }
            }
        }
        return c;
        
    }
    
}
