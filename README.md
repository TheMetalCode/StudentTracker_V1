StudentTracker_V1
=================

This is the Object Oriented Design and Development project submission for WGU IT student Jason Hagglund. It is being used for demonstration purposes as part of my final capstone project.

If you are a current WGU IT student, you are strongly advised against copying or referring 
to this code without attribution, or doing anything else with this code that would be in 
violation of WGU's policies against plagiarism. I assume no resonsibility for the misuse of 
these resources and the consequences that may result from such misuse.

Instructions for Usage
======================

This is a Java 6 Swing application developed using NetBeans (http://www.netbeans.org) as an IDE. This repository is, in fact, almost entirely consited of the contents of my NetBeans project folder. In the highly unlikely event that one would want to fork this code and do any of their own development on it, I would highly reccommend not straying from the NetBeans context that this project was developed in.

The code for this project can be viewed in any text editor in the src/GUT1/Task4/StudentTracker directory.

This repository also contains the executable JAR file, along with all the necessary items to configure your local machine to run the executable. What follows are brief instructions for setting up your local environment to run StudentTracker_V1 successfully. These instructions assume usage of Mac OSX Lion, but can be performed on a Windows machine given slight alterations in some of the steps.

1.) Clone this git repository to your local machine.

2.) Install MySQL 5.1 for OSX. Be sure to include the Start Package and the preferences pane. 

http://dev.mysql.com/downloads/mysql/5.1.html#macosx-dmg 

When the installation is complete, open up MySQL in System Preferences and start your local server.

3.) Add the following lines to your /users/[username]/.bash_profile or /users/[username]/.profile, whichever one exists:

alias mysql=/usr/local/mysql/bin/mysql

alias mysqladmin=/usr/local/mysql/bin/mysqladmin

4.) Open up a Terminal, cd to [local clone of StudentTracker_V1]/db, and run MySQL. Note that sudo will prompt you for your local administrator password: 

sudo /usr/local/mysql/bin/mysql

5.) Create the registrar database:

create schema registrar;

6.) Grant permissions to 'user1' on your MySQL server:

use registrar;

GRANT ALL ON registrar TO 'user1'@'localhost' IDENTIFIED BY 'user1';

This allows the StudentTracker executable to access the local database.

7.) Create the student table by executing the create_student_table sql script:

source create_student_table.sql;

8.) Seed the database by executing the seed_data.sql script:

source seed_data.sql;

9.) Exit MySQL by typing 'quit'.

10.) Your local system is now ready to run the JAR executable, located in dist/StudentTracker.jar.
The test plan originally submitted for this project (StudentTracker_TestPlan.rtf) should serve as a handy guide for how to properly use the application.
