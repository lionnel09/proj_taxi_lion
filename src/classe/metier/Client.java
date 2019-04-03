/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.metier;

/**
 *
 * @author Hp
 */
public class Client {

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
    protected int idadr;

    /**
     * adresse du client
     */
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
    public Client(int idclient, String nom, String prenom, String tel, int idadr) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.idadr = idadr;
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
    public int getIdadr() {
        return idadr;
    }

    /**
     * setter identifiant adresse
     *
     * @param idadr téléphone du client
     */
    public void setIdadr(int idadr) {
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
