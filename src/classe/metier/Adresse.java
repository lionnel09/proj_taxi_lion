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

    /**
     * constructeur par défaut
     */
    public Adresse() {

    }

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
    public Adresse(int idadr, int cp, String localite, String rue, String num) {
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

    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }

    /**
     * setter idadr
     *
     * @param idadr idadr
     */
    /**
     * getter code postal
     *
     * @return code postal
     */
    public int getCp() {
        return cp;
    }

    /**
     * setter code postal
     *
     * @param cp code postal
     */
    public void setCp(int cp) {
        this.cp = cp;
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
     * setter localite
     *
     * @param localite localité
     */
    public void setLocalite(String localite) {
        this.localite = localite;
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
     * setter rue
     *
     * @param rue rue de l'Adresse
     */
    public void setRue(String rue) {
        this.rue = rue;
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
     * setter numéro de rue
     *
     * @param num numéro de rue
     */
    public void setNum(String num) {
        this.num = num;
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

}
