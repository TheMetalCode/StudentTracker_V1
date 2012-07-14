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
public class GraduateTest {

    public GraduateTest() {
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
     * Test of setThesisTitle and getThesisTitle methods, of class Graduate.
     */
    @Test
    public void testGetThesisTitle() {
        System.out.println("set/get ThesisTitle");
        Graduate instance = new Graduate();
        instance.setThesisTitle("Stuff");
        String expResult = "Stuff";
        String result = instance.getThesisTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setThesisAdvisor and getThesisAdvisor methods, of class Graduate.
     */
    @Test
    public void testGetThesisAdvisor() {
        System.out.println("set/getThesisAdvisor");
        Graduate instance = new Graduate();
        instance.setThesisAdvisor("Your Mom");
        String expResult = "Your Mom";
        String result = instance.getThesisAdvisor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTuition method, of class Graduate.
     */
    @Test
    public void testCalculateTuitionResident() {
        System.out.println("calculateTuition Resident");
        int credHours = 12;
        Graduate instance = new Graduate();
        instance.setStatus("Resident");
        int expResult = 3600;
        int result = instance.calculateTuition(credHours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTuition method, of class Graduate.
     */
    @Test
    public void testCalculateTuitionNonresident() {
        System.out.println("calculateTuition Nonresident");
        int credHours = 12;
        Graduate instance = new Graduate();
        instance.setStatus("Nonresident");
        int expResult = 4200;
        int result = instance.calculateTuition(credHours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Graduate.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Graduate instance = new Graduate("Jack", "Mahan", 999999, 2.8F,
            "Nonresident", "Simona Mihai", "Graduate", "My Thesis", "My Advisor");
        String expResult = "Successfully added 1 student record!";
        String result = instance.add();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class Graduate.
     */
    @Test
    public void testQueryAfterAdd() throws Exception {
        System.out.println("query after add");
        Graduate instance = new Graduate("Jack", "Mahan", 999999, 2.8F,
            "Nonresident", "Simona Mihai", "Graduate", "My Thesis", "My Advisor");
        String expResult = "999999\tJack\tMahan\t2.8\tNonresident\t"
                + "Simona Mihai\tn/a\tMy Thesis\tMy Advisor\tn/a\tGraduate\n";
        String result = instance.query();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Graduate.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Graduate instance = new Graduate("Josh", "Wilson", 999999, 3.1F,
            "Resident", "Eric Wedge", "Graduate", "The Thesis", "The Advisor");
        String expResult = "Successfully updated 1 student record!";
        String result = instance.update();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class Graduate.
     */
    @Test
    public void testQueryAfterUpdate() throws Exception {
        System.out.println("query after update");
        Graduate instance = new Graduate("Josh", "Wilson", 999999, 3.1F,
            "Resident", "Eric Wedge", "Graduate", "The Thesis", "The Advisor");
        String expResult = "999999\tJosh\tWilson\t3.1\tResident\t"
                + "Eric Wedge\tn/a\tThe Thesis\tThe Advisor\tn/a\tGraduate\n";
        String result = instance.query();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Graduate.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Graduate instance = new Graduate();
        instance.setStudID(999999);
        String expResult = "Successfully deleted 1 student record!";
        String result = instance.delete();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class Graduate.
     */
    @Test
    public void testQueryAfterDelete() throws Exception {
        System.out.println("query after delete");
        Graduate instance = new Graduate("Josh", "Wilson", 999999, 3.1F,
            "Resident", "Eric Wedge", "Graduate", "The Thesis", "The Advisor");
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
        Graduate instance = new Graduate();
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
     * Test of toString method, of class Graduate.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Graduate instance = new Graduate("Josh", "Wilson", 999999, 3.1F,
            "Resident", "Eric Wedge", "Graduate", "The Thesis", "The Advisor");
        String expResult = "First Name: Josh\n"
                + "Last Name: Wilson\n"
                + "Student ID: 999999\n"
                + "GPA: 3.1\n"
                + "Status: Resident\n"
                + "Mentor: Eric Wedge\n"
                + "Student Type: Graduate\n"
                + "Thesis Title: The Thesis\n"
                + "Thesis Advisor: The Advisor";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}