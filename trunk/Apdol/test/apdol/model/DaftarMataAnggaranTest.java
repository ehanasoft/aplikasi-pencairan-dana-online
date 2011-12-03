/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.MataAnggaran;
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
public class DaftarMataAnggaranTest {
    
    public DaftarMataAnggaranTest() {
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
     * Test of getEntityManager method, of class DaftarMataAnggaran.
    
    @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarMataAnggaran instance = new DaftarMataAnggaran();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of getMataAnggaran method, of class DaftarMataAnggaran.
    
    @Test
    public void testGetMataAnggaran() {
    System.out.println("getMataAnggaran");
    DaftarMataAnggaran instance = new DaftarMataAnggaran();
    List expResult = null;
    List result = instance.getMataAnggaran();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of findMataAnggaran method, of class DaftarMataAnggaran.
    
    @Test
    public void testFindMataAnggaran() {
    System.out.println("findMataAnggaran");
    Long id = null;
    DaftarMataAnggaran instance = new DaftarMataAnggaran();
    MataAnggaran expResult = null;
    MataAnggaran result = instance.findMataAnggaran(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of rekamMataAnggaran method, of class DaftarMataAnggaran.
     */
    @Test
    public void testRekamMataAnggaran() {
        System.out.println("rekamMataAnggaran");
        MataAnggaran mataAnggaran = new MataAnggaran();
        mataAnggaran.setKodeMataAnggaran("123456");
        mataAnggaran.setNamaMataAnggaran("Pembayaran Asuransi");
        mataAnggaran.setNamaBKPK("Passiva");

        DaftarMataAnggaran instance = new DaftarMataAnggaran();
        try {
            instance.rekamMataAnggaran(mataAnggaran);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarMataAnggaran.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        MataAnggaran mataAnggaran;

        DaftarMataAnggaran instance = new DaftarMataAnggaran();
        List<MataAnggaran> list = instance.getMataAnggaran();
        mataAnggaran = list.get(1);
        mataAnggaran.setKodeMataAnggaran("123455");
        mataAnggaran.setNamaMataAnggaran("Obligasi");
        mataAnggaran.setNamaBKPK("Ekuitas");
        try {
            instance.edit(mataAnggaran);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarMataAnggaran.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        DaftarMataAnggaran instance = new DaftarMataAnggaran();
        List<MataAnggaran> list = instance.getMataAnggaran();
        MataAnggaran mataAnggaran = list.get(1);
        Long id = mataAnggaran.getId();
        try {
            instance.destroy(id);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isKodeExist method, of class DaftarMataAnggaran.
     */
    @Test
    public void testIsKodeExist() {
        System.out.println("isKodeExist");
        DaftarMataAnggaran instance = new DaftarMataAnggaran();
        List<MataAnggaran> list = instance.getMataAnggaran();
        MataAnggaran mataAnggaran = list.get(0);
        String kode = mataAnggaran.getKodeMataAnggaran();
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
     * Test of isMataAnggaranExist method, of class DaftarMataAnggaran.
     */
    @Test
    public void testIsNamaExist() {
        System.out.println("isMataAnggaranExist");
        DaftarMataAnggaran instance = new DaftarMataAnggaran();
        List<MataAnggaran> list = instance.getMataAnggaran();
        MataAnggaran mataAnggaran = list.get(0);
        String nama = mataAnggaran.getNamaMataAnggaran();
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
