/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Adresse;
import classe.metier.Client;
import connect.DBConnection;
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
public class ClientDAOTest {
    
    public ClientDAOTest() {
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
     * Test of read method, of class ClientDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idclient = 0;
        Adresse adr = new Adresse(0, 7000, "testloc", "testrue", "tnum");
        AdresseDAO adrinst = new AdresseDAO();
        adrinst.setConnection(dbConnect);
        adr = adrinst.create(adr);
        int idadr = adr.getIdadr();
        ClientDAO instance = new ClientDAO();
        instance.setConnection(dbConnect);
        Client obj= new Client(0, "testnom", "testpre", "testtel", idadr);
        Client expResult=instance.create(obj);
        Client result=instance.read(idclient);
        assertEquals("nom différent ",expResult.getNom(), result.getNom());
        assertEquals("prénom différent ",expResult.getPrenom(), result.getPrenom());
        assertEquals("tel différent ",expResult.getTel(), result.getTel());
        instance.delete(obj);
        adrinst.delete(adr);
        
    }

    /**
     * Test of create method, of class ClientDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Client obj = null;
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Client obj = null;
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClientDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Client obj = null;
        ClientDAO instance = new ClientDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
