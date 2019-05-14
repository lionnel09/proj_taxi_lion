package taxiDAO.Metier.Builder;

import classe.metier.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Hp
 */
public class Location {

    /**
     * identifiant unique de la Location
     */
    protected int idloc;
    /**
     * date de Location
     */
    protected java.util.Date dateloc;
    /**
     * kilométrage total
     */
    protected Double kmtotal;
    /**
     * acompte client
     */
    protected Double acompte;
    /**
     * total à payer
     */
    protected Double total;
    /**
     * identifiant du client qui fait la commande en clé secondaire
     */
    protected Client fkclient;
    /**
     * identifiant du taxi utilisé pour la Location
     */
    protected Voiture fktaxi;
    /**
     * identifiant de l'adresse de départ
     */
    protected Adresse idadr_deb;
    /**
     * identifiant de l'adresse d'arrivé
     */
    protected Adresse idadr_fin;

    /**
     * constructeur par défaut
     */
    public Location() {

    }

    /**
     * constructeur paramétré
     *
     * @param idloc identifiant location unique
     * @param dateloc date de location
     * @param kmtotal total de kilomètre parcoouru
     * @param acompte acompte client pour la location
     * @param total total à payer par le client
     * @param fkclient identifiant du client qui prend la location
     * @param fktaxi identifiant du taxi
     * @param idadr_deb identifiant adresse de départ
     * @param idadr_fin identifiant adresse d'arrivé
     */
    public Location(int idloc, Date dateloc, Double kmtotal, Double acompte, Double total, Client fkclient, Voiture fktaxi, Adresse idadr_deb, Adresse idadr_fin) {
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.fkclient = fkclient;
        this.fktaxi = fktaxi;
        this.idadr_deb = idadr_deb;
        this.idadr_fin = idadr_fin;
    }

    /**
     * getter acompte
     *
     * @return acompte client
     */
    public Double getAcompte() {
        return acompte;
    }

    /**
     * setter acompte
     *
     * @param acompte acompte client
     */
    public void setAcompte(Double acompte) {
        this.acompte = acompte;
    }

    /**
     * getter idloc
     *
     * @return identifiant de la Location
     */
    public int getIdloc() {
        return idloc;
    }

    /**
     * setter idloc
     *
     * @param idloc identifiant de la Location
     */
    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    /**
     * getter dateloc
     *
     * @return date de Location
     */
    public Date getDateloc() {
        return dateloc;
    }

    /**
     * setter dateloc
     *
     * @param dateloc date de Location
     */
    public void setDateloc(Date dateloc) {
        this.dateloc = dateloc;
    }

    /**
     * getter fkclient
     *
     * @return identifiant du client en clé étrangère
     */
    public Client getFkclient() {
        return fkclient;
    }

    /**
     * setter fkclient
     *
     * @param fkclient identifiant du client en clé étrangère
     */
    public void setFkclient(Client fkclient) {
        this.fkclient = fkclient;
    }

    /**
     * getter identifiant taxi
     *
     * @return identifiant taxi
     */
    public Voiture getFktaxi() {
        return fktaxi;
    }

    /**
     * setter fktaxi
     *
     * @param fktaxi clé étrangère taxi
     */
    public void setFktaxi(Voiture fktaxi) {
        this.fktaxi = fktaxi;
    }

    /**
     * getter adresse départ
     *
     * @return adresse de départ
     */
    public Adresse getIdadr_deb() {
        return idadr_deb;
    }

    /**
     * setter idadr_deb
     *
     * @param idadr_deb adresse de départ
     */
    public void setIdadr_deb(Adresse idadr_deb) {
        this.idadr_deb = idadr_deb;
    }

    /**
     * getter identifiant adresse d'arrivé
     *
     * @return identifiant adresse d'arrivé
     */
    public Adresse getIdadr_fin() {
        return idadr_fin;
    }

    /**
     * setter idadr_fin
     *
     * @param idadr_fin identifiant adresse d'arrivé
     */
    public void setIdadr_fin(Adresse idadr_fin) {
        this.idadr_fin = idadr_fin;
    }

    /**
     * getter km total
     *
     * @return km total
     */
    public Double getKmtotal() {
        return kmtotal;
    }

    /**
     * setter kmtotal
     *
     * @param kmtotal kilométrage total
     */
    public void setKmtotal(Double kmtotal) {
        this.kmtotal = kmtotal;
    }

    /**
     * getter total à payer
     *
     * @return total à payer
     */
    public Double getTotal() {
        return total;
    }

    /**
     * setter total
     *
     * @param total total à payer
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 97 * hash + Objects.hashCode(this.fktaxi);
        hash = 97 * hash + Objects.hashCode(this.fkclient);
        hash = 97 * hash + Objects.hashCode(this.fktaxi);
        hash = 96 * hash + Objects.hashCode(this.idadr_deb);
        hash = 97 * hash + Objects.hashCode(this.idadr_fin);
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.fkclient, other.fkclient)) {
            return false;
        }
        if (!Objects.equals(this.idadr_deb, other.idadr_deb)) {
            return false;
        }
        if (!Objects.equals(this.fktaxi, other.fktaxi)) {
            return false;
        }
        if (!Objects.equals(this.idadr_fin, other.idadr_fin)) {
            return false;
        }
        return true;
    }

    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "location{" + "idloc=" + idloc + ", dateloc=" + dateloc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", fkclient=" + fkclient + ", fktaxi=" + fktaxi + ", idadr_deb=" + idadr_deb + ", idadr_fin=" + idadr_fin + '}';
    }

}
