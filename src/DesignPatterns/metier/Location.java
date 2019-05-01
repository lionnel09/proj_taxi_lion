package DesignPatterns.metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Hp
 */
public class Location {

    private int idloc;
    private Set<Taxi> voit=new HashSet<>();
    public Location(int idloc){
        this.idloc=idloc;
    }

    public Set<Taxi> getVoit() {
        return voit;
    }

    public int getIdloc() {
        return idloc;
    }
    public int hashCode(){
        int hash=3;
        hash = 29* hash + Objects.hashCode(this.idloc);
        return hash;
    }
}

