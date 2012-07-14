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
public class PartTimeTest {

    public PartTimeTest() {
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
     * Test of setCompany and getCompany methods, of class PartTime.
     */
    @Test
    public void testGetCompany() {
        System.out.println("set/getCompany");
        PartTime instance = new PartTime();
        instance.setCompany("Rehnholm Industries");
        String expResult = "Rehnholm Industries";
        String result = instance.getCompany();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTuition method, of class PartTime.
     */
    @Test
    public void testCalculateTuitionResident() {
        System.out.println("calculateTuition Resident");
        int credHours = 12;
        PartTime instance = new PartTime();
        instance.setStatus("Resident");
        int expResult = 3000;
        int result = instance.calculateTuition(credHours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of calculateTuition method, of class PartTime.
     */
    @Test
    public void testCalculateTuitionNonresident() {
        System.out.println("calculateTuition Nonresident");
        int credHours = 12;
        PartTime instance = new PartTime();
        instance.setStatus("Nonresident");
        int expResult = 5400;
        int result = instance.calculateTuition(credHours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class PartTime.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        PartTime instance = new PartTime("Jack", "Mahan", 999999, 2.8F,
            "Nonresident", "Simona Mihai", "Part-Time", "Efinancial");
        String expResult = "Successfully added 1 student record!";
        String result = instance.add();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class PartTime.
     */
    @Test
    public void testQueryAfterAdd() throws Exception {
        System.out.println("query after add");
        PartTime instance = new PartTime("Jack", "Mahan", 999999, 2.8F,
            "Nonresident", "Simona Mihai", "Part-Time", "Efinancial");
        String expResult = "999999\tJack\tMahan\t2.8\tNonresident\t"
                + "Simona Mihai\tn/a\tn/a\tn/a\tEfinancial\tPart-Time\n";
        String result = instance.query();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PartTime.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        PartTime instance = new PartTime("Josh", "Wilson", 999999, 3.1F,
            "Resident", "Eric Wedge", "Part-Time", "Seattle Mariners");
        String expResult = "Successfully updated 1 student record!";
        String result = instance.update();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class PartTime.
     */
    @Test
    public void testQueryAfterUpdate() throws Exception {
        System.out.println("query after update");
        PartTime instance = new PartTime("Josh", "Wilson", 999999, 3.1F,
            "Resident", "Eric Wedge", "Part-Time", "Seattle Mariners");
        String expResult = "999999\tJosh\tWilson\t3.1\tResident\t"
                + "Eric Wedge\tn/a\tn/a\tn/a\tSeattle Mariners\tPart-Time\n";
        String result = instance.query();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PartTime.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        PartTime instance = new PartTime();
        instance.setStudID(999999);
        String expResult = "Successfully deleted 1 student record!";
        String result = instance.delete();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class PartTime.
     */
    @Test
    public void testQueryAfterDelete() throws Exception {
        System.out.println("query after delete");
        PartTime instance = new PartTime("Josh", "Wilson", 999999, 3.1F,
            "Resident", "Eric Wedge", "Part-Time", "Seattle Mariners");
        //instance.setStudID(999999);
        String expResult = "";
        String result = instance.query();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class PartTime.
     */
    @Test
    public void testQueryAll() throws Exception {
        System.out.println("queryAll");
        PartTime instance = new PartTime();
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
     * Test of toString method, of class PartTime.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PartTime instance = new PartTime("Josh", "Wilson", 999999, 3.1F,
            "Resident", "Eric Wedge", "Part-Time", "Seattle Mariners");
        String expResult = "First Name: Josh\n"
                + "Last Name: Wilson\n"
                + "Student ID: 999999\n"
                + "GPA: 3.1\n"
                + "Status: Resident\n"
                + "Mentor: Eric Wedge\n"
                + "Student Type: Part-Time\n"
                + "Company: Seattle Mariners";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}