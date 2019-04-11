/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Voiture;
import connect.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
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

    static Connection dbconnect;

    public TaxiDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbconnect = DBConnection.getConnection();
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
        Voiture expResult = null;
        Voiture result = instance.read(idtaxi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class TaxiDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Voiture obj =new Voiture(0,"testimma","testcarbu",23.3,"testdesc");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbconnect);
        Voiture expResult = new Voiture(0,"testimma","testcarbu",23.3,"testdesc");
        Voiture result = instance.create(obj);
        assertEquals("Carburant différent",expResult.getCarbu(), result.getCarbu());
        assertEquals("Description différentes",expResult.getDesc(), result.getDesc());
        assertEquals("Immatriculation différente",expResult.getImma(), result.getImma());
        assertEquals("Prix différent",expResult.getPkm(), result.getPkm());
        assertNotEquals("id non généré",expResult.getIdtaxi(), result.getIdtaxi());
        int idtaxi=result.getIdtaxi();
        obj=new Voiture(0,"testimma","testcarbu",23.3,"testdesc");
         try{
            Voiture result2 = instance.create(obj);
            fail("exception de doublon non déclenchée");
            instance.delete(result2);
        }
        catch(SQLException e){}
         instance.delete(result);
        
          obj=new Voiture(0,"testimma","testcarbu",23.3,"testdesc");
        try{
            Voiture result3 = instance.create(obj);
            fail("exception de code postal non déclenchée");
            instance.delete(result3);
        }
        catch(SQLException e){}
        
        
    }

    /**
     * Test of update method, of class TaxiDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Voiture obj = new Voiture(0,"testimma","testcarbu",23.3,"testdesc");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbconnect);
        
        
        obj.setCarbu("testcarbu2");
        obj.setDesc("testdesc2");
        obj.setImma("testimma2");
        obj.setPkm(20.2);
        Voiture expResult = new Voiture(0,"testimma","testcarbu",23.3,"testdesc");
        Voiture result = instance.update(obj);
        assertEquals(expResult.getCarbu(), result.getCarbu());
        assertEquals(expResult.getDesc(), result.getDesc());
        assertEquals(expResult.getPkm(), result.getPkm());
        assertEquals(expResult.getImma(), result.getImma());
        instance.delete(obj);
    }

    /**
     * Test of delete method, of class TaxiDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Voiture obj = null;
        TaxiDAO instance = new TaxiDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechimma method, of class TaxiDAO.
     */
    @Test
    public void testRechimma() throws Exception {
        System.out.println("rechimma");
        String imma = "";
        TaxiDAO instance = new TaxiDAO();
        Voiture expResult = null;
        Voiture result = instance.rechimma(imma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechdesc method, of class TaxiDAO.
     */
    @Test
    public void testRechdesc() throws Exception {
        System.out.println("rechdesc");
        String desc = "";
        TaxiDAO instance = new TaxiDAO();
        List<Voiture> expResult = null;
        List<Voiture> result = instance.rechdesc(desc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aff method, of class TaxiDAO.
     */
    @Test
    public void testAff() throws Exception {
        System.out.println("aff");
        TaxiDAO instance = new TaxiDAO();
        List<Voiture> expResult = null;
        List<Voiture> result = instance.aff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
