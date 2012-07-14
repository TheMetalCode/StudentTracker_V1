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
public class StudentTest {

    public StudentTest() {
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
     * Test of setFN and getFN methods, of class Student.
     */
    @Test
    public void testGetFN() {
        System.out.println("set/getFN");
        Student instance = new StudentImpl();
        instance.setFN("Dude!");
        String expResult = "Dude!";
        String result = instance.getFN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLN and getLN methods, of class Student.
     */
    @Test
    public void testGetLN() {
        System.out.println("set/getLN");
        Student instance = new StudentImpl();
        instance.setLN("Dude!");
        String expResult = "Dude!";
        String result = instance.getLN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStudID and getStudID methods, of class Student.
     */
    @Test
    public void testGetStudID() {
        System.out.println("set/getStudID");
        Student instance = new StudentImpl();
        instance.setStudID(123456);
        int expResult = 123456;
        int result = instance.getStudID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setGPA and getGPA methods, of class Student.
     */
    @Test
    public void testGetGPA() {
        System.out.println("set/getGPA");
        Student instance = new StudentImpl();
        instance.setGPA(3.5F);
        float expResult = 3.5F;
        float result = instance.getGPA();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus and getStatus methods, of class Student.
     */
    @Test
    public void testGetStatus() {
        System.out.println("set/getStatus");
        Student instance = new StudentImpl();
        instance.setStatus("Nonresident");
        String expResult = "Nonresident";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMentor and getMentor methods, of class Student.
     */
    @Test
    public void testGetMentor() {
        System.out.println("set/getMentor");
        Student instance = new StudentImpl();
        instance.setMentor("Severus Snape");
        String expResult = "Severus Snape";
        String result = instance.getMentor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStudentType and getStudentType methods, of class Student.
     */
    @Test
    public void testGetStudentType() {
        System.out.println("set/getStudentType");
        Student instance = new StudentImpl();
        instance.setStudentType("Undergraduate");
        String expResult = "Undergraduate";
        String result = instance.getStudentType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Student instance = new StudentImpl();
        instance.setFN("Harry");
        instance.setLN("Potter");
        instance.setStudID(647985);
        instance.setGPA(3.5F);
        instance.setStatus("Resident");
        instance.setMentor("Albus Dumbledore");
        instance.setStudentType("Unknown");
        String expResult = "First Name: Harry\n"
                + "Last Name: Potter\n"
                + "Student ID: 647985\n"
                + "GPA: 3.5\n"
                + "Status: Resident\n"
                + "Mentor: Albus Dumbledore\n"
                + "Student Type: Unknown\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class StudentImpl extends Student {

        @Override
        public int calculateTuition(int credHours) {
            return 0;
        }

        @Override
        public String add() {
            return "";
        }

        @Override
        public String update() {
            return "";
        }

        @Override
        public String delete() {
            return "";
        }

        @Override
        public String query() {
            return "";
        }
    }

}