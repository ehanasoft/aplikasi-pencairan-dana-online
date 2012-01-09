/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.SPM;
import java.util.List;
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
public class DaftarSPMTest {
    
    public DaftarSPMTest() {
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
     * Test of getEntityManager method, of class DaftarSPM.
     
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarSPM instance = new DaftarSPM();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSPM method, of class DaftarSPM.
    
    @Test
    public void testGetSPM() {
        System.out.println("getSPM");
        DaftarSPM instance = new DaftarSPM();
        List expResult = null;
        List result = instance.getSPM();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSPM method, of class DaftarSPM.
     */
    @Test
    public void testFindSPM() {
        System.out.println("findSPM");
        Long id = Long.parseLong("351"); // id pada database
        DaftarSPM instance = new DaftarSPM();
        String expResult = "12345";
        SPM result = instance.findSPM(id);
        String hasil = result.getNomorSpm();
        try {
            assertEquals(expResult, hasil);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of rekamSPM method, of class DaftarSPM.
     */
    @Test
    public void testRekamSPM() {
        System.out.println("rekamSPM");
        SPM spm = new SPM();
        spm.setNomorSpm("701");

        DaftarSPM instance = new DaftarSPM();
        int hasil1 = instance.getSPM().size(); //jumlah objek sebelum tambah objek
        instance.rekamSPM(spm);
        int hasil2 = instance.getSPM().size(); //jumlah objek setelah tambah objek

        try {
            assertEquals(hasil1 + 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarSPM.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        SPM spm;
        DaftarSPM instance = new DaftarSPM();
        List<SPM> list = instance.getSPM();
        spm = list.get(1);
        spm.setNomorSpm("701");
        try {
            instance.edit(spm);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarSPM.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = Long.parseLong("351"); // id pada database
        DaftarSPM instance = new DaftarSPM();
        int hasil1 = instance.getSPM().size(); //jumlah objek sebelum destroy
        instance.destroy(id);
        int hasil2 = instance.getSPM().size(); //jumlah objek setelah destroy
        try {
            assertEquals(hasil1 - 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
}
