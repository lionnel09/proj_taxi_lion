package classe.metier;

import java.time.LocalDate;
import java.util.Date;

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
    protected LocalDate dateloc;
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
    protected int fkclient;
    /**
     * identifiant du taxi utilisé pour la Location
     */
    protected int fktaxi;
    /**
     * identifiant de l'adresse de départ
     */
    protected int idadr_deb;
    /**
     * identifiant de l'adresse d'arrivé
     */
    protected int idadr_fin;

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
    public Location(int idloc, LocalDate dateloc, Double kmtotal, Double acompte, Double total, int fkclient, int fktaxi, int idadr_deb, int idadr_fin) {
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
    public LocalDate getDateloc() {
        return dateloc;
    }

    /**
     * setter dateloc
     *
     * @param dateloc date de Location
     */
    public void setDateloc(LocalDate dateloc) {
        this.dateloc = dateloc;
    }

    /**
     * getter fkclient
     *
     * @return identifiant du client en clé étrangère
     */
    public int getFkclient() {
        return fkclient;
    }

    /**
     * setter fkclient
     *
     * @param fkclient identifiant du client en clé étrangère
     */
    public void setFkclient(int fkclient) {
        this.fkclient = fkclient;
    }

    /**
     * getter identifiant taxi
     *
     * @return identifiant taxi
     */
    public int getFktaxi() {
        return fktaxi;
    }

    /**
     * setter fktaxi
     *
     * @param fktaxi clé étrangère taxi
     */
    public void setFktaxi(int fktaxi) {
        this.fktaxi = fktaxi;
    }

    /**
     * getter adresse départ
     *
     * @return adresse de départ
     */
    public int getIdadr_deb() {
        return idadr_deb;
    }

    /**
     * setter idadr_deb
     *
     * @param idadr_deb adresse de départ
     */
    public void setIdadr_deb(int idadr_deb) {
        this.idadr_deb = idadr_deb;
    }

    /**
     * getter identifiant adresse d'arrivé
     *
     * @return identifiant adresse d'arrivé
     */
    public int getIdadr_fin() {
        return idadr_fin;
    }

    /**
     * setter idadr_fin
     *
     * @param idadr_fin identifiant adresse d'arrivé
     */
    public void setIdadr_fin(int idadr_fin) {
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
