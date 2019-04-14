/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Voiture;
import connect.DBConnection;
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
        Voiture obj = new Voiture(0,"testimma1","testcarbu",23.0,"testdsc");
        Voiture expResult=instance.create(obj);
        idtaxi=expResult.getIdtaxi();
        Voiture result = instance.read(idtaxi);
        assertEquals("carburant différent",expResult.getCarbu(), result.getCarbu());
        assertEquals("immatriculation ",expResult.getImma(), result.getImma());
        assertEquals("prix au km",expResult.getPkm(), result.getPkm());
        assertEquals("description",expResult.getDesc(), result.getDesc());
        try{
            result=instance.read(0);
            fail("exception d'id inconnu non généré");
        }catch(SQLException e){}
        instance.delete(result);
        
    }

    /**
     * Test of create method, of class TaxiDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Voiture obj = null;
        TaxiDAO instance = new TaxiDAO();
        Voiture expResult = null;
        Voiture result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TaxiDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Voiture obj = null;
        TaxiDAO instance = new TaxiDAO();
        Voiture expResult = null;
        Voiture result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TaxiDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Voiture obj = new Voiture(0,"testimma2","testcarbu",23.0,"testdsc");
        TaxiDAO instance = new TaxiDAO();
        instance.setConnection(dbConnect);
        obj=instance.create(obj);
        instance.delete(obj);
        try{
            instance.read(obj.getIdtaxi());
            fail("exception de record introuvable non générée");
        }catch(SQLException e){}
    }

    /**
     * Test of rechimma method, of class TaxiDAO.
     */
    @Test
    public void testRechimma() throws Exception {
        System.out.println("rechimma");
        String imma = "testimma3";
        TaxiDAO instance = new TaxiDAO();
        Voiture obj = new Voiture(0,"testimma3","testcarbu",23.0,"testdsc");
        
        instance.setConnection(dbConnect);
        Voiture expResult =instance.create(obj);
        Voiture result = instance.rechimma(imma);
        if(expResult==null){
            fail("record introuvable");
        }
        assertEquals("immatriculation",expResult.getImma(), result.getImma());
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
        Voiture obj = new Voiture(1000,"testimma4","testcarbu",23.0,"testdsc");
        Voiture obj1= new Voiture(0,"testimma5","testcarbu",23.0,"testdsc");
        obj=instance.create(obj);
        obj1=instance.create(obj1);
        
        List<Voiture> result=instance.rechdesc(desc);
        if(result.indexOf(obj)<0) fail("record introuvable "+obj);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        instance.delete(obj);
        instance.delete(obj1);
        
        
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
