/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiDAO.Metier.Observer;

import taxiDAO.Metier.Builder.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hp
 */
public class Adresse {

    /**
     * identifiant Adresse
     */
    protected int idadr;
    /**
     * code postal de la localité
     */
    protected int cp;
    /**
     * localité
     */
    protected String localite;
    /**
     * rue
     */
    protected String rue;
    /**
     * numéro de rue
     */
    protected String num;
    protected Set<Location> locdeb = new HashSet<>();
    protected Set<Location> locfin = new HashSet<>();
    protected Set<Client> Client = new HashSet<>();

    /**
     * constructeur par défaut
     */
    /**
     * constructeur paramétré
     *
     * @param idadr identifiant de l'adresse du client
     * @param cp code postal de l'adresse
     * @param localite localité de l'adresse
     * @param rue rue de l'adresse
     * @param num numéro de l'adresse
     *
     */
    public Adresse(int adr, int cp, String localite, String rue, String num) {
        this.idadr = idadr;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
    }

    /**
     * getter idadr
     *
     * @return idadr
     */
    public int getIdadr() {
        return idadr;
    }

    /**
     * getter code postal
     *
     * @return code postal
     */
    public int getCp() {
        return cp;
    }

    /**
     * getter localite
     *
     * @return localite
     */
    public String getLocalite() {
        return localite;
    }

    /**
     * getter rue
     *
     * @return rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * getter numéro de rue
     *
     * @return numéro de rue
     */
    public String getNum() {
        return num;
    }

    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "adresse{" + "idadr=" + idadr + ", cp=" + cp + ", localite=" + localite + ", rue=" + rue + ", num=" + num + '}';
    }

    public Set<Location> getLocdeb() {
        return locdeb;
    }

    public Set<Location> getLocfin() {
        return locfin;
    }

    public Set<Client> getClient() {
        return Client;
    }

    @Override
    public int hashCode() {
        int hash = 2;
        hash = 37 * hash + this.idadr;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresse other = (Adresse) obj;
        if (this.idadr != other.idadr) {
            return false;
        }
        return true;
    }

}
