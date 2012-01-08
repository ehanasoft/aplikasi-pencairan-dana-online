/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Lokasi;
import apdol.entity.SatuanKerja;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Accio
 */
public class DaftarSatuanKerjaTest {

    public DaftarSatuanKerjaTest() {
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
     * Test of getEntityManager method, of class DaftarSatuanKerja.
     */
    /*
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarSatuanKerja instance = new DaftarSatuanKerja();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSatuanKerja method, of class DaftarSatuanKerja.
    
    @Test
    public void testGetSatuanKerja() {
    System.out.println("getSatuanKerja");
    DaftarSatuanKerja instance = new DaftarSatuanKerja();
    List expResult = null;
    List result = instance.getSatuanKerja();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of findSatuanKerja method, of class DaftarSatuanKerja.
    
    @Test
    public void testFindSatuanKerja() {
    System.out.println("findSatuanKerja");
    Long id = null;
    DaftarSatuanKerja instance = new DaftarSatuanKerja();
    SatuanKerja expResult = null;
    SatuanKerja result = instance.findSatuanKerja(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of rekamSatuanKerja method, of class DaftarSatuanKerja.
     */
    @Test
    public void testRekamSatuanKerja() {
        System.out.println("rekamSatuanKerja");
        SatuanKerja satker = new SatuanKerja();
        satker.setKodeSatker("123456");
        satker.setNamaSatker("Testing Satker");
        satker.setKodeDept("015");
        satker.setNamaDept("Kementerian Testing");
        satker.setKodeUnit("08");
        satker.setNamaUnit("Ditjen Testing");
        satker.setLokasi(null);

        DaftarSatuanKerja instance = new DaftarSatuanKerja();
        try {
            instance.rekamSatuanKerja(satker);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarSatuanKerja.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        SatuanKerja satker;
        DaftarSatuanKerja instance = new DaftarSatuanKerja();
        List<SatuanKerja> list = instance.getSatuanKerja();
        satker = list.get(1);
        satker.setKodeSatker("654321");
        satker.setNamaSatker("Testing2 Satker");
        satker.setKodeDept("005");
        satker.setNamaDept("Kementerian Testing2");
        satker.setKodeUnit("90");
        satker.setNamaUnit("Ditjen Testing2");
        satker.setLokasi(null);
        try {
            instance.edit(satker);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarSatuanKerja.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        SatuanKerja satker;
        DaftarSatuanKerja instance = new DaftarSatuanKerja();
        List<SatuanKerja> list = instance.getSatuanKerja();
        satker = list.get(1);
        Long id = satker.getId();
        try {
            instance.destroy(id);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isKodeExist method, of class DaftarSatuanKerja.
     */
    @Test
    public void testIsKodeExist() {
        System.out.println("isKodeExist");
        DaftarSatuanKerja instance = new DaftarSatuanKerja();
        List<SatuanKerja> list = instance.getSatuanKerja();
        SatuanKerja satker = list.get(0);
        String kode = satker.getKodeSatker();
        boolean expResult = true;
        boolean result = instance.isKodeExist(kode);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isNamaSatkerExist method, of class DaftarSatuanKerja.
     */
    @Test
    public void testIsNamaSatkerExist() {
        System.out.println("isNamaSatkerExist");
        DaftarSatuanKerja instance = new DaftarSatuanKerja();
        List<SatuanKerja> list = instance.getSatuanKerja();
        SatuanKerja satker = list.get(0);
        String namaSatker = satker.getNamaSatker();
        boolean expResult = true;
        boolean result = instance.isNamaSatkerExist(namaSatker);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
}
