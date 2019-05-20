/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiDAO.Metier.Observer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hp
 */
public class Client extends Observer {

    /**
     * identifiant unique du client
     */
    protected int idclient;
    /**
     * nom du client
     */
    protected String nom;
    /**
     * prénom du client
     */
    protected String prenom;
    /**
     * code postal de la localité
     */

    protected String tel;
    /**
     * tel
     */
    protected Adresse idadr;

    /**
     * adresse du client
     */
    protected Set<Location> locations = new HashSet<>();

    public Client() {
    }
    /**
     * constructeur paramétré
     *
     * @param idclient identifiant unique du client, affecté par la base de
     * données
     * @param nom nom du client
     * @param prenom prénom du client
     * @param tel téléphone du client
     * @param idadr identifiant de l'adresse du client
     */
    public Client(int idclient, String nom, String prenom, String tel, Adresse idadr) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.idadr = idadr;
    }

    @Override
    public void update(String msg) {
        System.out.println(nom + " " + prenom + " a reçu " + msg);
    }

    /**
     * getter idclient
     *
     * @return identifiant du client
     */
    public int getIdclient() {
        return idclient;
    }

    /**
     * setter idclient
     *
     * @param idclient identifiant du client
     */
    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    /**
     * getter nom
     *
     * @return nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom du client
     *
     * @param nom nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter prénom du client
     *
     * @return prénom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter nom du client
     *
     * @param prenom prénom du client
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter téléphone
     *
     * @return téléphone du client
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter téléphone
     *
     * @param tel téléphone du client
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * getter adresse id
     *
     * @return le numéro identifiant de l'adresse du client
     */
    public Adresse getIdadr() {
        return idadr;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    /**
     * setter identifiant adresse
     *
     * @param idadr téléphone du client
     */
    public void setIdadr(Adresse idadr) {
        this.idadr = idadr;
    }

    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "Client{" + "idclient=" + idclient + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", idadr=" + idadr + '}';
    }

}
