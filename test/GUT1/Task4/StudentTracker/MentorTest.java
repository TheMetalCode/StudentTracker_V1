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
public class MentorTest {

    public MentorTest() {
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
     * Test of setFN and getFN methods, of class Mentor.
     */
    @Test
    public void testGetFN() {
        System.out.println("set/getFN");
        Mentor instance = new Mentor();
        instance.setFN("Dude!");
        String expResult = "Dude!";
        String result = instance.getFN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLN and getLN methods, of class Mentor.
     */
    @Test
    public void testGetLN() {
        System.out.println("set/getLN");
        Mentor instance = new Mentor();
        instance.setLN("Stuff");
        String expResult = "Stuff";
        String result = instance.getLN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addStudent method, of class Mentor.
     */
    @Test
    public void testAddStudent() throws Exception {
        System.out.println("addStudent");
        int[] studentIDs = {100001,100002,100003,100004};
        Mentor instance = new Mentor("Bilbo", "Baggins");
        String expResult = "Successfully updated 1 student record!\n"
                + "Successfully updated 1 student record!\n"
                + "Successfully updated 1 student record!\n"
                + "Successfully updated 1 student record!\n";
        String result = instance.addStudent(studentIDs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listStudents method, of class Mentor.
     */
    @Test
    public void testListStudents() throws Exception {
        System.out.println("listStudents");
        Mentor instance = new Mentor("Bilbo", "Baggins");
        String expResult = "100001\tHarry\tPotter\n"
            + "100002\tRonald\tWeasley\n"
            + "100003\tHermoine\tGranger\n"
            + "100004\tDraco\tMalfoy\n";
        String result = instance.listStudents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Mentor.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        Mentor instance = new Mentor("Bilbo", "Baggins");
        instance.addStudent(1, 2, 3, 4);
        String theStudents = instance.listStudents();
        String expResult = "Mentor Name: Bilbo Baggins\n"
                + "Assigned Students: \n"
                + theStudents;
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}