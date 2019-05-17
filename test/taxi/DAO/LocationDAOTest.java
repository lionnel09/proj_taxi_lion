/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import classe.metier.Location;
import connect.DBConnection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import static java.time.temporal.TemporalQueries.localDate;
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
public class LocationDAOTest {

    public LocationDAOTest() {
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
     * Test of read method, of class LocationDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idloc = 0;
        LocationDAO instance = new LocationDAO();
        instance.setConnection(dbConnect);

        Location obj = new Location(0, LocalDate.of(2019, Month.MARCH, 20), 20.0, 22.3, 25.5, 0, 0, 0, 0);
        Location expResult = instance.create(obj);
        idloc = expResult.getIdloc();
        Location result = instance.read(idloc);
        assertEquals("Date différentes ", expResult.getDateloc(), result.getDateloc());
        assertEquals("acompte différents", expResult.getAcompte(), result.getAcompte());
        assertEquals("foreign key client différente ", expResult.getFkclient(), result.getFkclient());
        assertEquals("foreign key taxi différent ", expResult.getFktaxi(), result.getFktaxi());
        assertEquals("kilométrage différent ", expResult.getKmtotal(), result.getKmtotal());
        assertEquals("Total différent ", expResult.getTotal(), result.getTotal());
        assertEquals("", expResult, result);
        assertEquals("", expResult, result);
        instance.delete(obj);
    }

    /**
     * Test of create method, of class LocationDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Location obj = new Location(0, LocalDate.of(2019, Month.MARCH, 20), 20.0, 22.3, 25.5, 1, 2, 1, 2);

        LocationDAO instance = new LocationDAO();
        instance.setConnection(dbConnect);
        Location result = instance.create(obj);
        Location expResult = obj;
        assertEquals("Date différente", expResult.getDateloc(), result.getDateloc());

    }

    /**
     * Test of update method, of class LocationDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Location obj = null;
        LocationDAO instance = new LocationDAO();
        Location expResult = null;
        Location result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LocationDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Location obj = new Location(0, LocalDate.of(2019, Month.MARCH, 20), 20.0, 22.3, 25.5, 0, 0, 0, 0);
        LocationDAO instance = new LocationDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdloc());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }

    }

    /**
     * Test of aff method, of class LocationDAO.
     */
    @Test
    public void testAff() throws Exception {
        System.out.println("aff");
        int idloc = 0;
        LocationDAO instance = new LocationDAO();
        Double expResult = null;
        Double result = instance.aff(idloc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
