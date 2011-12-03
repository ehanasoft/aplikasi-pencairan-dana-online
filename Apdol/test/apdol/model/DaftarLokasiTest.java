/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Lokasi;
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
 * @author Hari RZ
 */
public class DaftarLokasiTest {

    public DaftarLokasiTest() {
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
     * Test of getEntityManager method, of class DaftarLokasi.
    
    @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarLokasi instance = new DaftarLokasi();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of getLokasi method, of class DaftarLokasi.
    
    @Test
    public void testGetLokasi() {
    System.out.println("getLokasi");
    DaftarLokasi instance = new DaftarLokasi();
    List expResult = null;
    List result = instance.getLokasi();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of findLokasi method, of class DaftarLokasi.
    
    @Test
    public void testFindLokasi() {
    System.out.println("findLokasi");
    Long id = null;
    DaftarLokasi instance = new DaftarLokasi();
    Lokasi expResult = null;
    Lokasi result = instance.findLokasi(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of rekamLokasi method, of class DaftarLokasi.
     */
    @Test
    public void testRekamLokasi() {
        System.out.println("rekamLokasi");
        Lokasi lokasi = new Lokasi();
        lokasi.setKodeLokasi("1234");
        lokasi.setNamaKota("Denpasar");
        lokasi.setNamaPropinsi("Bali");

        DaftarLokasi instance = new DaftarLokasi();
        try {
            instance.rekamLokasi(lokasi);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarLokasi.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Lokasi lokasi;

        DaftarLokasi instance = new DaftarLokasi();
        List<Lokasi> list = instance.getLokasi();
        lokasi = list.get(1);
        lokasi.setKodeLokasi("1234");
        lokasi.setNamaKota("Denpasar");
        lokasi.setNamaPropinsi("Bali");
        try {
            instance.edit(lokasi);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarLokasi.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        DaftarLokasi instance = new DaftarLokasi();
        List<Lokasi> list = instance.getLokasi();
        Lokasi lokasi = list.get(1);
        Long id = lokasi.getId();
        try {
            instance.destroy(id);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isKodeExist method, of class DaftarLokasi.
     */
    @Test
    public void testIsKodeExist() {
        System.out.println("isKodeExist");
        DaftarLokasi instance = new DaftarLokasi();
        List<Lokasi> list = instance.getLokasi();
        Lokasi lokasi = list.get(0);
        String kode = lokasi.getKodeLokasi();
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
     * Test of isKotaExist method, of class DaftarLokasi.
     */
    @Test
    public void testIsKotaExist() {
        System.out.println("isKotaExist");
        DaftarLokasi instance = new DaftarLokasi();
        List<Lokasi> list = instance.getLokasi();
        Lokasi lokasi = list.get(0);
        String nama = lokasi.getNamaKota();
        boolean expResult = true;
        boolean result = instance.isKotaExist(nama);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
}
