/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Adresse;
import connect.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
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
         try{
            result=instance.read(0);
            fail("exception d'id inconnu non générée");
        }catch(SQLException e){}
       instance.delete(result);
       
    }

    /**
     * Test of create method, of class AdresseDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Adresse obj=new Adresse(0,1000,"testloc","testrue","testnum");
        AdresseDAO instance = new AdresseDAO();
        instance.setConnection(dbConnect);
        Adresse expResult = new Adresse(0,1000,"testloc","testrue","testnum");
        Adresse result = instance.create(obj);
        assertEquals("code postal",expResult.getCp(),result.getCp());
        assertEquals("localité",expResult.getLocalite(), result.getLocalite());
        assertEquals("rue",expResult.getRue(), result.getRue());
        assertEquals("id différent",expResult.getIdadr(), result.getIdadr());
        int idadr=result.getIdadr();
        obj=new Adresse(0,1000,"testloc","testrue","testnum");
        try{
            Adresse result2 = instance.create(obj);
            fail("exception de doublon non déclenchée");
            instance.delete(result2);
        }
        catch(SQLException e){}
        instance.delete(result);
        obj=new Adresse(0,1000,"testloc","testrue","testnum");
        try{
            Adresse result3 = instance.create(obj);
            fail("exception de code postal non déclenchée");
            instance.delete(result3);
        }
        catch(SQLException e){}
    }

    /**
     * Test of update method, of class AdresseDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Adresse obj = new Adresse(0,1000,"testloc","testrue","testnum");
        AdresseDAO instance = new AdresseDAO();
        instance.setConnection(dbConnect);
        obj=instance.create(obj);
        obj.setLocalite("testloc2");
        obj.setCp(1001);
        obj.setNum("testnum2");
        obj.setRue("");
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
        Adresse obj = new Adresse(0,1000,"testloc","testrue","testnum");
        AdresseDAO instance = new AdresseDAO();
        instance.setConnection(dbConnect);
        obj=instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdadr());
            fail("exception de record introuvable non générée");
            
        }
        catch(SQLException e){}
        
    }
    
}
