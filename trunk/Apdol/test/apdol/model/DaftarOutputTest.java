/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Output;
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
public class DaftarOutputTest {
    
    public DaftarOutputTest() {
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
     * Test of getEntityManager method, of class DaftarOutput.
    
    @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarOutput instance = new DaftarOutput();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of getOutput method, of class DaftarOutput.
    
    @Test
    public void testGetOutput() {
    System.out.println("getOutput");
    DaftarOutput instance = new DaftarOutput();
    List expResult = null;
    List result = instance.getOutput();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of findOutput method, of class DaftarOutput.
    
    @Test
    public void testFindOutput() {
    System.out.println("findOutput");
    Long id = null;
    DaftarOutput instance = new DaftarOutput();
    Output expResult = null;
    Output result = instance.findOutput(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of rekamOutput method, of class DaftarOutput.
     */
    @Test
    public void testRekamOutput() {
        System.out.println("rekamOutput");
        Output output = new Output();
        output.setKodeOutput("1234");
        output.setNamaOutput("Peningkatan Mutu Pendidikan");

        DaftarOutput instance = new DaftarOutput();
        try {
            instance.rekamOutput(output);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarOutput.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Output output;

        DaftarOutput instance = new DaftarOutput();
        List<Output> list = instance.getOutput();
        output = list.get(1);
        output.setKodeOutput("1233");
        output.setNamaOutput("Penambahan Sarana Pendidikan");
        try {
            instance.edit(output);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarOutput.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        DaftarOutput instance = new DaftarOutput();
        List<Output> list = instance.getOutput();
        Output output = list.get(1);
        Long id = output.getId();
        try {
            instance.destroy(id);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isKodeExist method, of class DaftarOutput.
     */
    @Test
    public void testIsKodeExist() {
        System.out.println("isKodeExist");
        DaftarOutput instance = new DaftarOutput();
        List<Output> list = instance.getOutput();
        Output output = list.get(0);
        String kode = output.getKodeOutput();
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
     * Test of isOutputExist method, of class DaftarOutput.
     */
    @Test
    public void testIsOutputExist() {
        System.out.println("isOutputExist");
        DaftarOutput instance = new DaftarOutput();
        List<Output> list = instance.getOutput();
        Output output = list.get(0);
        String nama = output.getNamaOutput();
        boolean expResult = true;
        boolean result = instance.isOutputExist(nama);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
}
