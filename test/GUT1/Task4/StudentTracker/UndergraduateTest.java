/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUT1.Task4.StudentTracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author XPMUser
 */
public class UndergraduateTest {

    public UndergraduateTest() {
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
     * Test of setLevel and getLevel methods, of class Undergraduate.
     */
    @Test
    public void testGetLevel() {
        System.out.println("set/getLevel");
        Undergraduate instance = new Undergraduate();
        instance.setLevel("Freshman");
        String expResult = "Freshman";
        String result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Undergraduate.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Undergraduate instance = new Undergraduate("Jack", "Mahan", 999999, 2.8F,
            "Nonresident", "Simona Mihai", "Undergraduate", "Junior");
        String expResult = "Successfully added 1 student record!";
        String result = instance.add();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class Undergraduate.
     */
    @Test
    public void testQueryAfterAdd() throws Exception {
        System.out.println("query after add");
        Undergraduate instance = new Undergraduate("Jack", "Mahan", 999999, 2.8F,
            "Nonresident", "Simona Mihai", "Undergraduate", "Junior");
        String expResult = "999999\tJack\tMahan\t2.8\tNonresident\t"
                + "Simona Mihai\tJunior\tn/a\tn/a\tn/a\tUndergraduate\n";
        String result = instance.query();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Undergraduate.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Undergraduate instance = new Undergraduate("Josh", "Wilson", 999999, 3.0F,
                "Resident", "Eric Wedge", "Undergraduate", "Senior");
        String expResult = "Successfully updated 1 record!";
        String result = instance.update();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class Undergraduate.
     */
    @Test
    public void testQueryAfterUpdate() throws Exception {
        System.out.println("query after update");
        Undergraduate instance = new Undergraduate("Josh", "Wilson", 999999, 3.0F,
                "Resident", "Eric Wedge", "Undergraduate", "Senior");
        String expResult = "999999\tJosh\tWilson\t3\tResident\t"
                + "Eric Wedge\tSenior\tn/a\tn/a\tn/a\tUndergraduate\n";
        String result = instance.query();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Undergraduate.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Undergraduate instance = new Undergraduate();
        instance.setStudID(999999);
        String expResult = "Successfully deleted 1 record!";
        String result = instance.delete();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class Undergraduate.
     */
    @Test
    public void testQueryAfterDelete() throws Exception {
        System.out.println("query after delete");
        Undergraduate instance = new Undergraduate("Josh", "Wilson", 999999, 3.0F,
                "Resident", "Eric Wedge", "Undergraduate", "Senior");
        //instance.setStudID(999999);
        String expResult = "";
        String result = instance.query();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of queryAll method, of class Student.
     */
    @Test
    public void testQueryAll() throws Exception {
        System.out.println("queryAll");
        Undergraduate instance = new Undergraduate();
        String expResult = "100001\tHarry\tPotter\t3.5\tResident\tAlbus Dumbledore\tJunior\tn/a\tn/a\tn/a\tUndergraduate\n"
            + "100002\tRonald\tWeasley\t3.2\tNonresident\tMinerva McGonagall\tJunior\tn/a\tn/a\tn/a\tUndergraduate\n"
            + "100003\tHermoine\tGranger\t3.9\tResident\tHorace Slughorn\tn/a\tMuggles With Magic\tRemus Lupin\tn/a\tGraduate\n"
            + "100004\tDraco\tMalfoy\t3.7\tNonresident\tSeverus Snape\tn/a\tn/a\tn/a\tMinistry of Magic\tPart-Time\n";
        String result = Student.queryAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTuition method, of class Undergraduate.
     */
    @Test
    public void testCalculateTuitionResident() {
        System.out.println("calculateTuition Resident");
        int credHours = 12;
        Undergraduate instance = new Undergraduate();
        instance.setStatus("Resident");
        int expResult = 2400;
        int result = instance.calculateTuition(credHours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

     /**
     * Test of calculateTuition method, of class Undergraduate.
     */
    @Test
    public void testCalculateTuitionNonresident() {
        System.out.println("calculateTuition Nonresident");
        int credHours = 12;
        Undergraduate instance = new Undergraduate();
        instance.setStatus("Nonresident");
        int expResult = 4800;
        int result = instance.calculateTuition(credHours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Undergraduate.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Undergraduate instance = new Undergraduate("Josh", "Wilson", 999999, 3.0F,
                "Resident", "Eric Wedge", "Undergraduate", "Senior");
        String expResult = "First Name: Josh\n"
                + "Last Name: Wilson\n"
                + "Student ID: 999999\n"
                + "GPA: 3.0\n"
                + "Status: Resident\n"
                + "Mentor: Eric Wedge\n"
                + "Student Type: Undergraduate\n"
                + "Level: Senior";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}