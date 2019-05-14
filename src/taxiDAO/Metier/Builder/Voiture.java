package taxiDAO.Metier.Builder;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hp
 */
public class Voiture {

    /**
     * identifiant unique du taxi
     */
    protected int idtaxi;
    /**
     * immatriculation
     */
    protected String imma;
    /**
     * capacité du réservoir
     */
    protected String carbu;
    /**
     * prix au km
     */
    protected Double pkm;
    /**
     * Description
     */
    protected String desc;
    protected Set<Location> mesLocations = new HashSet<>();

    /**
     * constructeur par défaut
     */
    public Voiture() {
    }

    private Voiture(Taxibuilder tx) {
        this.idtaxi = tx.idtaxi;
        this.imma = tx.imma;
        this.carbu = tx.carbu;
        this.pkm = tx.pkm;
        this.desc = tx.desc;
    }

    /**
     * constructeur paramétré
     *
     * @param idtaxi identifiant unique du taxi
     * @param imma immatriculation de la voiture
     * @param carbu capacité du carburant
     * @param pkm prix au km
     * @param desc description
     *
     */
    public Voiture(int idtaxi, String imma, String carbu, Double pkm, String desc) {
        this.idtaxi = idtaxi;
        this.imma = imma;
        this.carbu = carbu;
        this.pkm = pkm;
        this.desc = desc;
    }

    public Voiture(String imma, String carbu, Double pkm, String desc) {
        this.imma = imma;
        this.carbu = carbu;
        this.pkm = pkm;
        this.desc = desc;
    }

    /**
     * getter carbu
     *
     * @return carburant
     */
    public String getCarbu() {
        return carbu;
    }

    /**
     * getter idtaxi
     *
     * @return identifiant du taxi
     */
    public int getIdtaxi() {
        return idtaxi;
    }

    /**
     * getter imma
     *
     * @return immatriculation
     */
    public String getImma() {
        return imma;
    }

    /**
     * getter pkm
     *
     * @return prix au km
     */
    public Double getPkm() {
        return pkm;
    }

    /**
     * getter desc
     *
     * @return description du taxi
     */
    public String getDesc() {
        return desc;
    }

    /**
     * setter idtaxi
     *
     * @param idtaxi identifiant du taxi
     */
    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    /**
     * setter imma
     *
     * @param imma immatriculation
     */
    public void setImma(String imma) {
        this.imma = imma;
    }

    /**
     * setter carbu
     *
     * @param carbu carburant
     */
    public void setCarbu(String carbu) {
        this.carbu = carbu;
    }

    /**
     * setter pkm
     *
     * @param pkm prix au km
     */
    public void setPkm(Double pkm) {
        this.pkm = pkm;
    }

    /**
     * setter desc
     *
     * @param desc description
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "Voiture{" + "idtaxi=" + idtaxi + ", imma=" + imma + ", carbu=" + carbu + ", pkm=" + pkm + ", desc=" + desc + '}';
    }
    public Set<Location> getMesLocations(){
        return mesLocations;
    }
    public int hashCode(){
        int hash=5;
        hash=37*hash+this.idtaxi;
        return hash;
    }
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
        final Voiture other = (Voiture) obj;
        if (this.idtaxi != other.idtaxi) {
            return false;
        }
        return true;
    }

    public static class Taxibuilder {

        /**
         * identifiant unique du taxi
         */
        protected int idtaxi;
        /**
         * immatriculation
         */
        protected String imma;
        /**
         * capacité du réservoir
         */
        protected String carbu;
        /**
         * prix au km
         */
        protected Double pkm;
        /**
         * Description
         */
        protected String desc;
        
        public Taxibuilder setIdtaxi(int idtaxi){
            this.idtaxi=idtaxi;
            return this;
        }
        public Taxibuilder setImma(String imma){
            this.imma=imma;
            return this;
        }
        public Taxibuilder setCarbu(String carbu){
            this.carbu=carbu;
            return this;
        }
        public Taxibuilder setPkm(Double pkm){
            this.pkm=pkm;
            return this;
        }
        public Taxibuilder setDesc(String desc){
            this.desc=desc;
            return this;
        }
        public Voiture build() throws Exception{
            if(idtaxi<=0 || imma==null || desc==null || pkm<=0 || carbu==null) throw new  Exception("informations de construction incomplètes");
            return new Voiture(this);
        }
    }

}
