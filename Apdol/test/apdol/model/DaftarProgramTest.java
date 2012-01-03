/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Program;
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
public class DaftarProgramTest {
    
    public DaftarProgramTest() {
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
     * Test of getEntityManager method, of class DaftarProgram.
     
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarProgram instance = new DaftarProgram();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProgram method, of class DaftarProgram.
     
    @Test
    public void testGetProgram() {
        System.out.println("getProgram");
        DaftarProgram instance = new DaftarProgram();
        List expResult = null;
        List result = instance.getProgram();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findProgram method, of class DaftarProgram.
     */
    @Test
    public void testFindProgram() {
        System.out.println("findProgram");
        Long id = Long.parseLong("851"); // id pada database
        DaftarProgram instance = new DaftarProgram();
        String expResult = "Apaa";
        Program result = instance.findProgram(id);
        String hasil = result.getNmprogram();
        try {
            assertEquals(expResult, hasil);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of rekamProgram method, of class DaftarProgram.
     */
    @Test
    public void testRekamProgram() {
        System.out.println("rekamProgram");
        Program program = new Program();
        program.setKdprogram("1231");
        program.setNmprogram("Pendidikan");

        DaftarProgram instance = new DaftarProgram();
        int hasil1 = instance.getProgram().size(); //jumlah objek sebelum tambah objek
        instance.rekamProgram(program);
        int hasil2 = instance.getProgram().size(); //jumlah objek setelah tambah objek

        try {
            assertEquals(hasil1 + 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarProgram.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Program program;
        DaftarProgram instance = new DaftarProgram();
        List<Program> list = instance.getProgram();
        program = list.get(1);
        program.setKdprogram("7654");
        program.setNmprogram("Kesehatan");
        try {
            instance.edit(program);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarProgram.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = Long.parseLong("852"); // id pada database
        DaftarProgram instance = new DaftarProgram();
        int hasil1 = instance.getProgram().size(); //jumlah objek sebelum destroy
        instance.destroy(id);
        int hasil2 = instance.getProgram().size(); //jumlah objek setelah destroy
        try {
            assertEquals(hasil1 - 1, hasil2);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isKodeExist method, of class DaftarProgram.
     */
    @Test
    public void testIsKodeExist() {
        System.out.println("isKodeExist");
        DaftarProgram instance = new DaftarProgram();
        List<Program> list = instance.getProgram();
        Program program = list.get(0);
        String kode = program.getKdprogram();
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
     * Test of isNamaExist method, of class DaftarProgram.
     */
    @Test
    public void testIsNamaExist() {
        System.out.println("isNamaExist");
        DaftarProgram instance = new DaftarProgram();
        List<Program> list = instance.getProgram();
        Program program = list.get(0);
        String nama = program.getNmprogram();
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
