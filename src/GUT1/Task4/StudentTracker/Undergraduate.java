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
 * The Undergraduate class extends Student and adds the level attribute.
 * @author Jason Hagglund
 */
public class Undergraduate extends Student {

    //The level attribute is specific to the Undergraduate student
    private String level;

    /**
     * Empty default constructor.
     */
    public Undergraduate() {

    }

    /**
     * Constructs an Undergraduate object with both common attributes
     * inherited from Student and the specific level attribute.
     * @param theFN The student's first name
     * @param theLN The student's last name
     * @param theStudID The student's student ID number
     * @param theGPA The student's grade point average
     * @param theStatus The student's residency status
     * @param theMentor The student's assigned mentor
     * @param theLevel The student's grade level
     */
    public Undergraduate(String theFN, String theLN, int theStudID, float theGPA,
            String theStatus, String theMentor, String theStudentType,
            String theLevel) {

        super(theFN, theLN, theStudID, theGPA, theStatus, theMentor, theStudentType);
        //this.setStudentType("Undergraduate");
        level = theLevel;
    }

    /**
     * Sets the level attribute of the Undergraduate object.
     * @param newLevel The student's grade level
     */
    public void setLevel(String newLevel) {
        level = newLevel;
    }

    /**
     * Returns the current value of the Undergraduate object's level
     * attribute.
     * @return The student's grade level
     */
    public String getLevel() {
        return level;
    }
    
    /**
     * Implementing from Student, this method adds an Undergraduate student
     * to the database.
     * @return A message indicating the success of the insertion
     */
    @Override
    public String add() {
        Statement stmnt = null;
        ResultSet rs = null;
        String result = null;
        String error = null;

        try {
            //Create DB connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://"
                + "localhost:3306/registrar", "user1", "user1");
            stmnt = conn.createStatement();

            //System.out.println("Connected to db!");

            //Create SQL statement
            String sqlStmnt = "INSERT INTO student (studentID, firstName,"
                    + " lastName, gpa, status, mentor, level, thesisTitle, "
                    + "thesisAdvisor, company, studentType) "
                    + "VALUES ('"
                    + this.getStudID() + "', '"
                    + this.getFN() + "', '"
                    + this.getLN() + "', '"
                    + this.getGPA() + "', '"
                    + this.getStatus() + "', '"
                    + this.getMentor() + "', '"
                    + this.level + "', '"
                    + "n/a', 'n/a', 'n/a', '"
                    + this.getStudentType() + "')";

            //System.out.println(sqlStmnt);

            //Insert record and note success
            int rowsAdded = stmnt.executeUpdate(sqlStmnt);
            result = "Successfully added " + rowsAdded + " student record!";
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
     * Implementing from Student, this method updates an Undergraduate student
     * record.
     * @return A message indicating the success of the update
     */
    @Override
    public String update() {

        Statement stmnt = null;
        ResultSet rs = null;
        String result = null;
        String error = null;

        try {
            //Create DB connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://"
                + "localhost:3306/registrar", "user1", "user1");
            stmnt = conn.createStatement();

            //System.out.println("Connected to db!");

            //Create SQL statement
            String sqlStmnt = "UPDATE student "
                    + "SET firstName = '" + this.getFN()
                    + "', lastName = '" + this.getLN()
                    + "', gpa = " + this.getGPA()
                    + ", status = '" + this.getStatus()
                    + "', mentor = '" + this.getMentor()
                    + "', studentType = '" + this.getStudentType()
                    + "', level = '" + this.level
                    + "' WHERE studentID = '" + this.getStudID() + "'";

            //System.out.println(sqlStmnt);

            //Execute query and build results
            int rowsAffected = stmnt.executeUpdate(sqlStmnt);
            result = "Successfully updated " + rowsAffected + " record!";

            //Close connections and return result
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
     * Implementing from Student, this method deletes an Undergraduate student
     * record from the database.
     * @return A message indicating the success of the deletion
     */
    @Override
    public String delete() {
        Statement stmnt = null;
        ResultSet rs = null;
        String result = null;
        String error = null;

        try {
            //Create DB connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://"
                + "localhost:3306/registrar", "user1", "user1");
            stmnt = conn.createStatement();

            //System.out.println("Connected to db!");

            //Create SQL statement
            String sqlStmnt = "DELETE FROM student WHERE studentID = '"
                    + this.getStudID() + "'";

            //System.out.println(sqlStmnt);

            //Execute deletion and build results
            int rowsDeleted = stmnt.executeUpdate(sqlStmnt);
            result = "Successfully deleted " + rowsDeleted + " record!";

            //Close connections and return result
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
     * Implementing from Student, this method queries the database based
     * on the contents of the Undergraduate object.
     * @return The query results
     */
    @Override
    public String query() {
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

            //Create base SQL statement
            String sqlStmnt = "SELECT * FROM student WHERE ";

            //Add studentID if included in query request
            String studIDquery = Integer.toString(this.getStudID());
            if (Student.numbersOnly(studIDquery) & this.getStudID() != 0) {
                sqlStmnt += "studentID = '" + this.getStudID() + "'";
            }

            //Add firstName if included in query request
            String firstNamequery = this.getFN();
            if (Student.containsText(firstNamequery)) {
                sqlStmnt += "\nAND firstName = '" + this.getFN() + "'";
            }

            //Add lastName if included in query request
            String lastNamequery = this.getLN();
            if (Student.containsText(lastNamequery)) {
                sqlStmnt += "\nAND lastName = '" + this.getLN() + "'";
            }

            //Add gpa if included in query request
            String gpaQuery = Float.toString(this.getGPA());
            if (Student.containsGPA(gpaQuery) & this.getGPA() != 0) {
                sqlStmnt += "\nAND FORMAT(gpa, 1) = "
                        + "FORMAT(" + this.getGPA() + ", 1)";
            }

            //Add status if included in query request
            String statusQuery = this.getStatus();
            if (Student.containsText(statusQuery) & !statusQuery.equals(" ")) {
                sqlStmnt += "\nAND status = '" + this.getStatus() + "'";
            }

            //Add mentor if included in query request
            String mentorQuery = this.getMentor();
            if (Student.containsText(mentorQuery)) {
                sqlStmnt += "\nAND mentor = '" + this.getMentor() + "'";
            }

            //Add studentType if included in query request
            String studTypequery = this.getStudentType();
            if (Student.containsText(studTypequery) & !studTypequery.equals(" ")) {
                sqlStmnt += "\nAND studentType = '" + this.getStudentType()
                        + "'";
            }

            //Add level if included in query request
            if (Student.containsText(level) & !level.equals(" ")) {
                sqlStmnt += "\nAND level = '" + level + "'";
            }

            /**
             * If studentID isn't the first parameter, sqlStmnt is left
             * with invalid SQL syntax; specifically, there will be a
             * "WHERE AND".  This detects whether or not there is such
             * an occurrence in the query statement and, if so, fixes it.
             */
            if (sqlStmnt.contains("WHERE \nAND")) {
                sqlStmnt = sqlStmnt.replace("WHERE \nAND", "WHERE");
            }

            //System.out.println(sqlStmnt);


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
     * Implementing from Student, this method calculates the tuition due
     * based on credit hours and residency status.
     * @param credHours The credit hours for which the student is enrolled
     * @return The tuition due
     */
    @Override
    public int calculateTuition(int credHours) {
        int tuitionDue = 0;
        String theStatus = this.getStatus();
        
        if (theStatus.equals("Resident")) {
            tuitionDue = credHours * 200;
        }
        
        if (theStatus.equals("Nonresident")) {
            tuitionDue = credHours * 400;
        }

        return tuitionDue;
    }

     /**
     * Provides a String representation of the contents of an Undergraduate
     * object.
     * @return The contents of the Undergraduate object.
     */
    @Override
    public String toString() {
        String studString = super.toString()
                + "Level: " + level;

        return studString;
    }



}
