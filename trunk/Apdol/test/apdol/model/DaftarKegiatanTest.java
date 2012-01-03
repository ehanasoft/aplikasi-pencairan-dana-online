/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Kegiatan;
import java.util.List;
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
public class DaftarKegiatanTest {

    public DaftarKegiatanTest() {
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
     * Test of getEntityManager method, of class DaftarKegiatan.
    
    @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarKegiatan instance = new DaftarKegiatan();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of getKegiatan method, of class DaftarKegiatan.
    
    @Test
    public void testGetKegiatan() {
    System.out.println("getKegiatan");
    DaftarKegiatan instance = new DaftarKegiatan();
    List expResult = null;
    List result = instance.getKegiatan();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of findKegiatan method, of class DaftarKegiatan.
    
    @Test
    public void testFindKegiatan() {
    System.out.println("findKegiatan");
    Long id = null;
    DaftarKegiatan instance = new DaftarKegiatan();
    Kegiatan expResult = null;
    Kegiatan result = instance.findKegiatan(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of edit method, of class DaftarKegiatan.
     */
    @Test
    public void testRekamKegiatan() {
        System.out.println("rekamKegiatan");
        Kegiatan kegiatan = new Kegiatan();
        kegiatan.setKdgiat("1243");
        kegiatan.setNmgiat("Belajar");

        DaftarKegiatan instance = new DaftarKegiatan();
        int hasil1 = instance.getKegiatan().size(); //jumlah objek sebelum tambah objek
        instance.rekamKegiatan(kegiatan);
        int hasil2 = instance.getKegiatan().size(); //jumlah objek setelah tambah objek

        try {
            assertEquals(hasil1 + 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testEdit() {
        System.out.println("edit");
        Kegiatan kegiatan;

        DaftarKegiatan instance = new DaftarKegiatan();
        List<Kegiatan> list = instance.getKegiatan();
        kegiatan = list.get(1);
        kegiatan.setKdgiat("1234");
        kegiatan.setNmgiat("Pertambangan");
        try {
            instance.edit(kegiatan);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarKegiatan.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        DaftarKegiatan instance = new DaftarKegiatan();
        List<Kegiatan> list = instance.getKegiatan();
        Kegiatan kegiatan = list.get(1);
        Long id = kegiatan.getId();
        try {
            instance.destroy(id);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isKodeExist method, of class DaftarKegiatan.
     */
    @Test
    public void testIsKodeExist() {
        System.out.println("isKodeExist");
        DaftarKegiatan instance = new DaftarKegiatan();
        List<Kegiatan> list = instance.getKegiatan();
        Kegiatan kegiatan = list.get(0);
        String kode = kegiatan.getKdgiat();
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
     * Test of isKegiatanExist method, of class DaftarKegiatan.
     */
    @Test
    public void testIsNamaKegiatanExist() {
        System.out.println("isKegiatanExist");
        DaftarKegiatan instance = new DaftarKegiatan();
        List<Kegiatan> list = instance.getKegiatan();
        Kegiatan kegiatan = list.get(0);
        String nama = kegiatan.getNmgiat();
        boolean expResult = true;
        boolean result = instance.isNamaExist(nama);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
}
