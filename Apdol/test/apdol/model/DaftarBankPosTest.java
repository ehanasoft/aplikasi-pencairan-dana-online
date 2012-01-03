/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.BankPos;
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
public class DaftarBankPosTest {

    public DaftarBankPosTest() {
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
     * Test of getEntityManager method, of class DaftarBankPos.
    
    @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarBankPos instance = new DaftarBankPos();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of getBankPos method, of class DaftarBankPos.
    
    @Test
    public void testGetBankPos() {
    System.out.println("getBankPos");
    DaftarBankPos instance = new DaftarBankPos();
    List expResult = null;
    List result = instance.getBankPos();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of findBankPos method, of class DaftarBankPos.
     */
    @Test
    public void testFindBankPos() {
        System.out.println("findBankPos");
        Long id = Long.parseLong("305"); // id pada database
        DaftarBankPos instance = new DaftarBankPos();
        String expResult = "Bang Toyib";
        BankPos result = instance.findBankPos(id);
        String hasil = result.getNmbankpos();
        try {
            assertEquals(expResult, hasil);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of rekamBankPos method, of class DaftarBankPos.
     */
    @Test
    public void testRekamBankPos() {
        System.out.println("rekamBankPos");
        BankPos bankpos = new BankPos();
        bankpos.setKdbankpos("123");
        bankpos.setNmbankpos("Bank Oma");

        DaftarBankPos instance = new DaftarBankPos();
        int hasil1 = instance.getBankPos().size(); //jumlah objek sebelum tambah objek
        instance.rekamBankPos(bankpos);
        int hasil2 = instance.getBankPos().size(); //jumlah objek setelah tambah objek

        try {
            assertEquals(hasil1 + 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarBankPos.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        BankPos bankpos;
        DaftarBankPos instance = new DaftarBankPos();
        List<BankPos> list = instance.getBankPos();
        bankpos = list.get(1);
        bankpos.setKdbankpos("876");
        bankpos.setNmbankpos("Bank Jii");
        try {
            instance.edit(bankpos);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarBankPos.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = Long.parseLong("601"); // id pada database
        DaftarBankPos instance = new DaftarBankPos();
        int hasil1 = instance.getBankPos().size(); //jumlah objek sebelum destroy
        instance.destroy(id);
        int hasil2 = instance.getBankPos().size(); //jumlah objek setelah destroy
        try {
            assertEquals(hasil1 - 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isKodeExist method, of class DaftarBankPos.
     */
    @Test
    public void testIsKodeExist() {
        System.out.println("isKodeExist");
        DaftarBankPos instance = new DaftarBankPos();
        List<BankPos> list = instance.getBankPos();
        BankPos bankpos = list.get(0);
        String kode = bankpos.getKdbankpos();
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
     * Test of isNamaExist method, of class DaftarBankPos.
     */
    @Test
    public void testIsNamaExist() {
        System.out.println("isNamaExist");
        DaftarBankPos instance = new DaftarBankPos();
        List<BankPos> list = instance.getBankPos();
        BankPos bankpos = list.get(0);
        String nama = bankpos.getNmbankpos();
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
