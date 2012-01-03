/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Pejabat;
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
 * @author AlfieSaHid
 */
public class DaftarPejabatTest {
    
    public DaftarPejabatTest() {
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
     * Test of getEntityManager method, of class DaftarPejabat.
     
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarPejabat instance = new DaftarPejabat();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPejabat method, of class DaftarPejabat.
     
    @Test
    public void testGetPejabat() {
        System.out.println("getPejabat");
        DaftarPejabat instance = new DaftarPejabat();
        List expResult = null;
        List result = instance.getPejabat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPejabat method, of class DaftarPejabat.
     */
    @Test
    public void testFindPejabat() {
        System.out.println("findPejabat");
        Long id = Long.parseLong("155"); // id pada database
        DaftarPejabat instance = new DaftarPejabat();
        String expResult = "Eko";
        Pejabat result = instance.findPejabat(id);
        String hasil = result.getNama();
        try {
            assertEquals(expResult, hasil);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of rekamPejabat method, of class DaftarPejabat.
     */
    @Test
    public void testRekamPejabat() {
        System.out.println("rekamPejabat");
        Pejabat pejabat = new Pejabat();
        pejabat.setNip("123456789012345678");
        pejabat.setNama("Yoga");
        pejabat.setNmjabatan("Kepala Seksi");
        pejabat.setKdgol("III/a Penata Muda");
        pejabat.setRolejabatan("2");
        pejabat.setKetjabatan("Kasi Pencairan Dana");

        DaftarPejabat instance = new DaftarPejabat();
        int hasil1 = instance.getPejabat().size(); //jumlah objek sebelum tambah objek
        instance.rekamPejabat(pejabat);
        int hasil2 = instance.getPejabat().size(); //jumlah objek setelah tambah objek

        try {
            assertEquals(hasil1 + 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarPejabat.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Pejabat pejabat;
        DaftarPejabat instance = new DaftarPejabat();
        List<Pejabat> list = instance.getPejabat();
        pejabat = list.get(1);
        pejabat.setNip("123546789098765431");
        pejabat.setNama("Wahid");
        try {
            instance.edit(pejabat);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarPejabat.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = Long.parseLong("1051"); // id pada database
        DaftarPejabat instance = new DaftarPejabat();
        int hasil1 = instance.getPejabat().size(); //jumlah objek sebelum destroy
        instance.destroy(id);
        int hasil2 = instance.getPejabat().size(); //jumlah objek setelah destroy
        try {
            assertEquals(hasil1 - 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isKodeExist method, of class DaftarPejabat.
     */
    @Test
    public void testIsKodeExist() {
        System.out.println("isKodeExist");
        DaftarPejabat instance = new DaftarPejabat();
        List<Pejabat> list = instance.getPejabat();
        Pejabat pejabat = list.get(0);
        String nip = pejabat.getNip();
        boolean expResult = true;
        boolean result = instance.isKodeExist(nip);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isNamaExist method, of class DaftarPejabat.
     */
    @Test
    public void testIsNamaExist() {
        System.out.println("isNamaExist");
        DaftarPejabat instance = new DaftarPejabat();
        List<Pejabat> list = instance.getPejabat();
        Pejabat pejabat = list.get(0);
        String nama = pejabat.getNama();
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
