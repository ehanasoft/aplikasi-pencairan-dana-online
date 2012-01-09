/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wahid
 */
public class DaftarRincianKegiatanTest {
    
    public DaftarRincianKegiatanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class DaftarRincianKegiatan.
     
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarRincianKegiatan instance = new DaftarRincianKegiatan();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRincianKegiatan method, of class DaftarRincianKegiatan.
     
    @Test
    public void testGetRincianKegiatan() {
        System.out.println("getRincianKegiatan");
        DaftarRincianKegiatan instance = new DaftarRincianKegiatan();
        List expResult = null;
        List result = instance.getRincianKegiatan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRincianKegiatan method, of class DaftarRincianKegiatan.
     
    @Test
    public void testFindRincianKegiatan() {
        System.out.println("findRincianKegiatan");
        Long id = null;
        DaftarRincianKegiatan instance = new DaftarRincianKegiatan();
        RincianKegiatan expResult = null;
        RincianKegiatan result = instance.findRincianKegiatan(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rekamRincianKegiatan method, of class DaftarRincianKegiatan.
     
    @Test
    public void testRekamRincianKegiatan() {
        System.out.println("rekamRincianKegiatan");
        RincianKegiatan rincianKegiatan = null;
        DaftarRincianKegiatan instance = new DaftarRincianKegiatan();
        instance.rekamRincianKegiatan(rincianKegiatan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class DaftarRincianKegiatan.
     
    @Test
    public void testEdit() {
        System.out.println("edit");
        RincianKegiatan rincianKegiatan = null;
        DaftarRincianKegiatan instance = new DaftarRincianKegiatan();
        instance.edit(rincianKegiatan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class DaftarRincianKegiatan.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = Long.parseLong("55"); // id pada database
        DaftarRincianKegiatan instance = new DaftarRincianKegiatan();
        int hasil1 = instance.getRincianKegiatan().size(); //jumlah objek sebelum destroy
        instance.destroy(id);
        int hasil2 = instance.getRincianKegiatan().size(); //jumlah objek setelah destroy
        try {
            assertEquals(hasil1 - 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
}
