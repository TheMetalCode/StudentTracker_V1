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
 * The Graduate class extends Student and adds the attributes thesisTitle
 * and thesisAdvisor.
 * @author Jason Hagglund
 */
public class Graduate extends Student {

    //Attributes specific to Graduate
    private String thesisTitle;
    private String thesisAdvisor;

    /**
     * Empty default constructor.
     */
    public Graduate() {

    }

    /**
     * Constructs a Graduate object with attributes inherited from Student
     * as well as the attributes specific to Graduate students.
     * @param theFN The student's first name
     * @param theLN The student's last name
     * @param theStudID The student's student ID number
     * @param theGPA The student's grade point average
     * @param theStatus The student's residency status
     * @param theMentor The student's assigned mentor
     * @param theThesisTitle The student's graduate thesis title
     * @param theThesisAdvisor The student's graduate thesis mentor
     */
    public Graduate(String theFN, String theLN, int theStudID, float theGPA,
            String theStatus, String theMentor, String theStudentType, 
            String theThesisTitle, String theThesisAdvisor) {

        super(theFN, theLN, theStudID, theGPA, theStatus, theMentor, theStudentType);
        thesisTitle = theThesisTitle;
        thesisAdvisor = theThesisAdvisor;
        //this.setStudentType("Graduate");
    }

    /**
     * Sets the thesisTitle attribute for the Graduate object.
     * @param newTitle The student's graduate thesis title
     */
    public void setThesisTitle(String newTitle) {
        thesisTitle = newTitle;
    }

    /**
     * Sets the thesisAdvisor attribute for the Graduate object.
     * @param newAdvisor The student's graduate thesis advisor
     */
    public void setThesisAdvisor(String newAdvisor) {
        thesisAdvisor = newAdvisor;
    }

    /**
     * Returns the current value of the Graduate object's thesisTitle attribute.
     * @return The student's graduate thesis title
     */
    public String getThesisTitle() {
        return thesisTitle;
    }

    /**
     * Returns the current value of the Graduate object's thesisAdvisor attribute.
     * @return The student's graduate thesis advisor
     */
    public String getThesisAdvisor() {
        return thesisAdvisor;
    }

    /**
     * Implementing from Student, this method calculates the tuition due for a
     * Graduate student based on credit hours and residency status.
     * @param credHours The credit hours for which the student is enrolled
     * @return The tuition due
     */
    @Override
    public int calculateTuition(int credHours) {
        int tuitionDue = 0;
        String theStatus = this.getStatus();

        if (theStatus.equals("Resident")) {
            tuitionDue = credHours * 300;
        }

        if (theStatus.equals("Nonresident")) {
            tuitionDue = credHours * 350;
        }

        return tuitionDue;
    }

    /**
     * Implementing from Student, this method adds a Graduate student record
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
                    + this.getMentor() + "', "
                    + "'n/a', '"
                    + thesisTitle + "', '"
                    + thesisAdvisor + "', '"
                    + "n/a', '"
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
     * Implementing from Student, this updates a Graduate student record.
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

            //Create SQL statement
            String sqlStmnt = "UPDATE student "
                    + "SET firstName = '" + this.getFN()
                    + "', lastName = '" + this.getLN()
                    + "', gpa = " + this.getGPA()
                    + ", status = '" + this.getStatus()
                    + "', mentor = '" + this.getMentor()
                    + "', thesisTitle = '" + thesisTitle
                    + "', thesisAdvisor = '" + thesisAdvisor
                    + "', studentType = '" + this.getStudentType()
                    + "' WHERE studentID = '" + this.getStudID() + "'";

            //Execute query and build results
            int rowsAffected = stmnt.executeUpdate(sqlStmnt);
            result = "Successfully updated " + rowsAffected + " student record!";

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
     * Implementing from Student, this method deletes a Graduate student record
     * from the database.
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

            //Create SQL statement
            String sqlStmnt = "DELETE FROM student WHERE studentID = '"
                    + this.getStudID() + "'";

            //Execute deletion and build results
            int rowsDeleted = stmnt.executeUpdate(sqlStmnt);
            result = "Successfully deleted " + rowsDeleted + " student record!";

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
     * Implementing from Student, this method queries the database based on 
     * the contents of a Graduate object.
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
            if (Student.numbersOnly(gpaQuery) & this.getGPA() != 0) {
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
            if (Student.containsText(studTypequery)) {
                sqlStmnt += "\nAND studentType = '" + this.getStudentType()
                        + "'";
            }

            //Add thesisTitle if included in query request
            if (Student.containsText(thesisTitle)) {
                sqlStmnt += "\nAND thesisTitle = '" + thesisTitle + "'";
            }

            //Add thesisAdvisor if included in query request
            if (Student.containsText(thesisAdvisor)) {
                sqlStmnt += "\nAND thesisAdvisor = '" + thesisAdvisor + "'";
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
     * Provides a String representation of a Graduate object's contents.
     * @return The contents of the Graduate object.
     */
    @Override
    public String toString() {
        String studString = super.toString()
                + "Thesis Title: " + thesisTitle + "\n"
                + "Thesis Advisor: " + thesisAdvisor;

        return studString;
    }

}
