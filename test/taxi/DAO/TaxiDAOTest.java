package taxi.DAO;

import classe.metier.Adresse;
import classe.metier.Client;
import classe.metier.Location;
import classe.metier.Voiture;
import connect.DBConnection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static taxi.DAO.AdresseDAOTest.dbConnect;

/**
 *
 * @author Hp
 */
public class TaxiDAOTest {

    public TaxiDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class TaxiDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idtaxi = 0;
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        Voiture obj = new Voiture(0, "testimma1", "testcarbu", 23.0, "testdsc");
        Voiture expResult = instance.create(obj);
        idtaxi = expResult.getIdtaxi();
        Voiture result = instance.read(idtaxi);
        assertEquals("carburant différent", expResult.getCarbu(), result.getCarbu());
        assertEquals("immatriculation ", expResult.getImma(), result.getImma());
        assertEquals("prix au km", expResult.getPkm(), result.getPkm());
        assertEquals("description", expResult.getDesc(), result.getDesc());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non généré");
        } catch (SQLException e) {
        }
        instance.delete(result);

    }

    /**
     * Test of create method, of class TaxiDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Voiture obj = new Voiture(0, "testimma7", "testcarbu", 23.0, "testdsc");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        Voiture result = instance.create(obj);

        Voiture expResult = obj;

        assertEquals("différence imma", expResult.getImma(), result.getImma());
        assertEquals("différence carburant", expResult.getCarbu(), result.getCarbu());
        assertEquals("différence prix", expResult.getPkm(), result.getPkm());
        assertEquals("différence description ", expResult.getDesc(), result.getDesc());
        instance.delete(obj);
    }

    /**
     * Test of update method, of class TaxiDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Voiture obj = new Voiture(0, "testimma6", "testcarbu", 23.0, "testdsc");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setImma("TestImma");
        obj.setCarbu("testCarbu");
        obj.setPkm(25.0);
        obj.setDesc("TestDesc");

        Voiture result = instance.update(obj);
        Voiture expResult = obj;
        assertEquals("différence imma", expResult.getImma(), result.getImma());
        assertEquals("différence carburant", expResult.getCarbu(), result.getCarbu());
        assertEquals("différence prix", expResult.getPkm(), result.getPkm());
        assertEquals("différence description ", expResult.getDesc(), result.getDesc());
        instance.delete(obj);
    }

    /**
     * Test of delete method, of class TaxiDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Voiture obj = new Voiture(0, "testimma2", "testcarbu", 23.0, "testdsc");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdtaxi());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        //Delete en cascade 
        obj = instance.create(obj);
        int idtaxi = obj.getIdtaxi();
        Adresse adr = new Adresse(0, 7000, "testloc", "testrue", "tnum");
        AdresseDAO adrinst = new AdresseDAO();
        adrinst.setConnection(dbConnect);
        adr = adrinst.create(adr);
        int idadr = adr.getIdadr();
        Client cl = new Client(0, "testnom", "testpre", "testtel", idadr);
        ClientDAO clinst = new ClientDAO();
        clinst.setConnection(dbConnect);
        clinst.create(cl);
        int idcl = cl.getIdclient();

        Location loc = new Location(0, LocalDate.of(2019, Month.MARCH, 20), 20.0, 22.3, 25.5, idcl, idtaxi, 1, idadr);
        LocationDAO locinst = new LocationDAO();
        locinst.setConnection(dbConnect);
        locinst.create(loc);

        int lc = loc.getIdloc();
        locinst.delete(loc);
        clinst.delete(cl);
        adrinst.delete(adr);
        instance.delete(obj);

    }

    /**
     * Test of rechimma method, of class TaxiDAO.
     */
    @Test
    public void testRechimma() throws Exception {
        System.out.println("rechimma");
        String imma = "testimma3";
        TaxiDAO instance = new TaxiDAO();
        Voiture obj = new Voiture(0, "testimma3", "testcarbu", 23.0, "testdsc");

        instance.setConnection(dbConnect);
        Voiture expResult = instance.create(obj);
        Voiture result = instance.rechimma(imma);
        if (expResult == null) {
            fail("record introuvable");
        }
        assertEquals("immatriculation", expResult.getImma(), result.getImma());
        instance.delete(obj);

    }

    /**
     * Test of rechdesc method, of class TaxiDAO.
     */
    @Test
    public void testRechdesc() throws Exception {
        System.out.println("rechdesc");
        String desc = "testdsc";
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        Voiture obj = new Voiture(1000, "testimma4", "testcarbu", 23.0, "testdsc");
        Voiture obj1 = new Voiture(0, "testimma5", "testcarbu", 23.0, "testdsc");
        obj = instance.create(obj);
        obj1 = instance.create(obj1);
        List<Voiture> result = instance.rechdesc(desc);
        List<Voiture> expResult = new ArrayList();
        expResult.add(obj);
        expResult.add(obj1);
        for (int i = 0; i < result.size(); i++) {
            assertEquals("différence imma", expResult.get(i).getImma(), result.get(i).getImma());
            assertEquals("différence carburant", expResult.get(i).getCarbu(), result.get(i).getCarbu());
            assertEquals("différence prix", expResult.get(i).getPkm(), result.get(i).getPkm());
            assertEquals("différence description ", expResult.get(i).getDesc(), result.get(i).getDesc());
        }
        instance.delete(obj);
        instance.delete(obj1);

    }

}
