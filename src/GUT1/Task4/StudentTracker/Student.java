/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUT1.Task4.StudentTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The Student class is the abstract class from which particular
 * types of students inherit global methods and attributes.
 *
 * @author Jason Hagglund
 */
public abstract class Student {

    /**
     * These are the global attributes that apply to all Student objects
     * and are inherited by all child objects.
     */
    private String firstName;
    private String lastName;
    private int studentID;
    private float gpa;
    private String status;
    private String mentor;
    private String studentType;

    /**
     * Empty default constructor.
     */
    public Student() {

    }

    /**
     * Constructs a Student object with full set of common attributes.
     * @param theFN The student's first name
     * @param theLN The student's last name
     * @param theStudID The student's student ID number
     * @param theGPA The student's grade point average
     * @param theStatus The student's residency status
     * @param theMentor The student's assigned mentor
     */
    public Student(String theFN, String theLN, int theStudID, float theGPA,
            String theStatus, String theMentor, String theStudentType) {

        firstName = theFN;
        lastName = theLN;
        studentID = theStudID;
        gpa = theGPA;
        status = theStatus;
        mentor = theMentor;
        studentType = theStudentType;
    }

    /**
     * Sets the firstName attribute of a Student object.
     * @param newFN The Student's first name
     */
    public void setFN(String newFN) {
        firstName = newFN;
    }

    /**
     * Sets the lastName attribute of a Student object.
     * @param newLN The Student's last name
     */
    public void setLN(String newLN) {
        lastName = newLN;
    }

    /**
     * Sets the studentID attribute of a Student object.
     * @param newStudID The student's student ID number
     */
    public void setStudID(int newStudID) {
        studentID = newStudID;
    }

    /**
     * Sets the gpa attribute of a Student object.
     * @param newGPA The student's grade point average
     */
    public void setGPA(float newGPA) {
        gpa = newGPA;
    }

    /**
     * Sets the status attribute of a Student object.
     * @param newStatus The student's residency status
     */
    public void setStatus(String newStatus) {
        status = newStatus;
    }

    /**
     * Sets the mentor attribute of a Student object.
     * @param newMentor The student's assigned mentor
     */
    public void setMentor(String newMentor) {
        mentor = newMentor;
    }

    /**
     * Sets the studentType attribute of a Student object.
     * @param newStudType
     */
    public void setStudentType(String newStudType) {
        studentType = newStudType;
    }

    /**
     * Returns the current value of the Student object's firstName attribute.
     * @return The student's first name
     */
    public String getFN() {
        return firstName;
    }

    /**
     * Returns the current value of the Student object's lastName attribute.
     * @return The student's last name
     */
    public String getLN() {
        return lastName;
    }

    /**
     * Returns the current value of the Student object's studentID attribute.
     * @return The student's student ID number
     */
    public int getStudID() {
        return studentID;
    }

    /**
     * Returns the current value of the Student object's gpa attribute.
     * @return The student's grade point average
     */
    public float getGPA() {
        return gpa;
    }

    /**
     * Returns the current value of the Student object's status attribute.
     * @return The student's residency status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the current value of the Student object's mentor attribute.
     * @return The student's assigned mentor
     */
    public String getMentor() {
        return mentor;
    }

    /**
     * Returns the current value of the Student object's studentType attribute.
     * @return The student type
     */
    public String getStudentType() {
        return studentType;
    }

    /**
     * This method queries all records in the student table.
     * @return All records in the student table
     */
    public static String queryAll() {
        Statement stmnt = null;
        ResultSet rs = null;
        String result = "";
        String error = "";

        try {
            //Create DB connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://"
                + "localhost:3306/registrar", "user1", "user1");
            stmnt = conn.createStatement();

            //System.out.println("Connected to db!");

            //Create SQL statement
            String sqlStmnt = "SELECT * FROM student";

            //Execute query
            rs = stmnt.executeQuery(sqlStmnt);

            //Parse and return the results
            while (rs.next()) {
                result += rs.getString("studentID") + "\t"
                        + rs.getString("firstName") + "\t"
                        + rs.getString("lastName") + "\t"
                        + rs.getString("gpa") + "\t"
                        + rs.getString("status") + "\t"
                        + rs.getString("mentor") + "\t"
                        + rs.getString("level") + "\t"
                        + rs.getString("thesisTitle") + "\t"
                        + rs.getString("thesisAdvisor") + "\t"
                        + rs.getString("company") + "\t"
                        + rs.getString("studentType") + "\n";
            }

            //Close connections and return result
            rs.close();
            stmnt.close();
            conn.close();
            return result;
        }

        catch (Exception e) {
            error = "There is an error with the database connection"
                    + " or with the query statment.  Please try again!";
            e.printStackTrace();
            return error;
        }
    }

    /**
     * Utility method to check if a string contains a valid
     * number that can be parsed as an int (studentID, creditHours) or a
     * float (gpa).
     * @param studIDString A candidate string to be parsed as a studentID
     * @return true if valid, false if not
     */
    public static boolean numbersOnly(String numString) {
        if (numString == null || numString.isEmpty()) {
            return false;
        }

        for (int i = 0; i < numString.length(); i++) {
            if (!Character.isDigit(numString.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Utility method to check if a string contains actual text.
     * @param string A candidate string
     * @return true if valid, false if not
     */
    public static boolean containsText(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }

        if (string.startsWith(" ")) {
            return false;
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDefined(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsGPA(String gpaString) {
        if (gpaString == null || gpaString.isEmpty()) {
            return false;
        }

        if (!gpaString.matches("\\d{0,4}\\.\\d{0,9}")) {
            return false;
        }
        
        return true;
    }

    /**
     * The abstract method to calculate a student's tuition that is implemented
     * by each subclass.
     * @param credHours The number of credit hours for which the student is enrolled
     * @return The tuition due
     */
    public abstract int calculateTuition(int credHours);

    /**
     * The abstract method to add records to the database that is implemented
     * by each subclass.
     * @return A message indicating a successful insertion
     */
    public abstract String add();

    /**
     * The abstract method to update records in the database that is implemented
     * by each subclass.
     * @return A message indicating a successful update
     */
    public abstract String update();

    /**
     * The abstract method to delete records from the database that is 
     * implemented by each subclass.
     * @return A message indicating a successful deletion
     */
    public abstract String delete();

    /**
     * The abstract method to query the database that is implemented by each
     * subclass.
     * @return The query results
     */
    public abstract String query();

     /**
     * Provides a string representation of a Student object's contents.
     * @return The contents of the Student object.
     */
    @Override
    public String toString() {
        String studString = "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "Student ID: " + studentID + "\n"
                + "GPA: " + gpa + "\n"
                + "Status: " + status + "\n"
                + "Mentor: " + mentor + "\n"
                + "Student Type: " + studentType + "\n";

        return studString;
    }

}
