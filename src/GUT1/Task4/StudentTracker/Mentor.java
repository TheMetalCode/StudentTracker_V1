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
 * The Mentor class create mentors and lists of associated students
 * per mentor
 * @author Jason Hagglund
 */
public class Mentor {

    //Mentor attributes
    private String firstName;
    private String lastName;
    private String studentList;
    
        
    /**
     * Empty default constructor.
     */
    public Mentor() {
        
    }
    
    /**
     * Constructs a mentor object with no students assigned.
     * @param theFN The mentor's first name
     * @param theLN The mentor's last name
     */
    public Mentor(String theFN, String theLN) {
        firstName = theFN;
        lastName = theLN;
    }

    /**
     * Sets the firstName attribute of the Mentor object.
     * @param newFN The mentor's first name
     */
    public void setFN(String newFN) {
        firstName = newFN;
    }

    /**
     * Sets the lastName attribute of the Mentor object.
     * @param newLN The mentor's last name
     */
    public void setLN(String newLN) {
        lastName = newLN;
    }

    /**
     * Returns the current value of the Mentor object's firstName attribute.
     * @return The mentor's first name
     */
    public String getFN() {
        return firstName;
    }

    /**
     * Returns the current value of the Mentor object's lastName attribute.
     * @return The mentor's last name
     */
    public String getLN() {
        return lastName;
    }

    /**
     * This method assigns students to a mentor by updating the affected
     * student records in the database.
     * @param studentIDs The studentIDs of the students to be assigned to the
     * mentor
     * @return A message indicating a successful update, for each update
     */
    public String addStudent(int... studentIDs) {
        Statement stmnt = null;
        ResultSet rs = null;
        String result = "";
        String error = "";

        for (int s : studentIDs) {
            try {
                //Create DB connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://"
                    + "localhost:3306/registrar", "user1", "user1");
                stmnt = conn.createStatement();

                //Create SQL statement
                String sqlStmnt = "UPDATE student "
                        + "SET mentor = '" + this.firstName + " " + this.lastName
                        + "' WHERE studentID = '" + s + "'";

                //Execute update and build results
                int rowsAffected = stmnt.executeUpdate(sqlStmnt);
                result += "Successfully updated " + rowsAffected + " student record!\n";

                //Close connections and return result
                stmnt.close();
                conn.close();
                }

            catch (Exception e) {
                error = "There is an error with the database connection"
                        + " or with the query statment.  Please try again!";
                e.printStackTrace();
                return error;
                }
            }
        return result;

    }

    /**
     * This method creates a list of student names assigned to a mentor.
     * @return A list of assigned students
     */
    public String listStudents() {
        Statement stmnt = null;
        ResultSet rs = null;
        String result = "";
        String error = "";

        try {
            //Create DB connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://"
                + "localhost:3306/registrar", "user1", "user1");
            stmnt = conn.createStatement();

            //Create SQL statement
            String sqlStmnt = "SELECT * FROM student "
                    + "WHERE mentor = '"
                    + this.firstName + " " + this.lastName + "'";

            //Execute query
            rs = stmnt.executeQuery(sqlStmnt);

            //Parse and return the results
            while (rs.next()) {
                result += rs.getString("studentID") + "\t"
                        + rs.getString("firstName") + "\t"
                        + rs.getString("lastName") + "\n";
            }

            //Close connections and return result
            rs.close();
            stmnt.close();
            conn.close();
            studentList = result;
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
     * Provides a String representation of the Mentor object's contents.
     * @return The contents of the mentor object
     */
    @Override
    public String toString() {
        

        String mentorContent = "Mentor Name: "
                + firstName + " " + lastName
                + "\n"
                + "Assigned Students: "
                + "\n"
                + studentList;
        
        return mentorContent;
    }

}
