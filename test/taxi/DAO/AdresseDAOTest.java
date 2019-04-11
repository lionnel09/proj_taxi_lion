/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Adresse;
import connect.DBConnection;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp
 */
public class AdresseDAOTest {
    static Connection dbConnect;
    public AdresseDAOTest() {
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
     * Test of read method, of class AdresseDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idadr = 0;
        AdresseDAO instance = new AdresseDAO();
        instance.setConnection(dbConnect);
        Adresse obj=new Adresse(0,1000,"testloc","testrue","testnum");
        Adresse expResult = instance.create(obj);
        idadr=expResult.getIdadr();
        Adresse result = instance.read(idadr);
        assertEquals("code postal",expResult.getCp(),result.getCp());
        assertEquals("localité",expResult.getLocalite(), result.getLocalite());
        assertEquals("rue",expResult.getRue(), result.getRue());
        assertEquals("id différent",expResult.getIdadr(), result.getIdadr());
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of create method, of class AdresseDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Adresse obj = null;
        AdresseDAO instance = new AdresseDAO();
        Adresse expResult = null;
        Adresse result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AdresseDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Adresse obj = null;
        AdresseDAO instance = new AdresseDAO();
        Adresse expResult = null;
        Adresse result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AdresseDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Adresse obj = null;
        AdresseDAO instance = new AdresseDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
