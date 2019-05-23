Setup Instructions
==================

1.  Install the Java SE Development Kit (JDK) 11 from http://www.oracle.com/technetwork/java/javase/downloads/index.html
NOTE: due to licensing issues, we use OpenJDK (http://openjdk.java.net/install/ ), but the Oracle JDK is still free for non-commercial use.

2.  Install Tomcat 9 from http://tomcat.apache.org/
	- In the installation wizard, be sure to set the HTTP port to 80, or it will default to 8080.


3.  Copy the Web application configuration files to Tomcat
     a: In the <TOMCAT_HOME>\conf subdirectory create a subdirectory structure Catalina\localhost where <TOMCAT_HOME> is the directory you installed tomcat to.
  
     b. From the hand out cd copy the xml files in the tomcat_conf subdirectory to the localhost directory. (This configures Tomcat with all the web applications required for the exercises)
     
     c. If you missed setting the HTTP port to 80 during the installation process, you can make the following change in <TOMCAT_HOME>\conf\server.xml:
    <Connector port="80" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />     

   
4.  Install MySQL CommunityServer 5.x which can be downloaded from https://dev.mysql.com/downloads/mysql/


5.  Install the course database files.
     a: From a console (command prompt), login to mysql

        This is achieved by typing:

   	mysql --user=root -p

	mysql must be in your path - if its not you need to configure this or run mysql from the bin subdirectory
        of where you installed mysql.

   	enter the password when prompted (normally root unless you changed it on installation)

     b: Inside the mysql console run the command "source PATH\dbdump\rainforest.sql;"

        where PATH is the path to the file rainforest.sql which is on your handout cd in the dbdump subdirectory
   
   This should create the databases and tables required for the exercises.
      
      Confirm this by typing 
      show databases;
      
      which should list all the databases.
      
     c: Grant permissions for the databases, by running the following command for each database
      
        grant all on DATABASE_NAME.* to student@localhost identified by 'student';
      
        where DATABASE_NAME is db517.
        Repeat this for DATABASE_NAME set to dbex71, dbex81, dbex82, dbex83


6.  Install Spring Tools 4 for Eclipse (STS), which can be downloaded from https://spring.io/tools/sts (the core Eclipse [at least the Oxygen release] is also sufficient if you don't need the Spring-specific functionality).
	
	NOTE: if you have multiple JDKs installed, open the file "SpringToolSuite4.ini" in your STS install dir.
	- From the STS docs: Add a line at the beginning "-vm" and an additional line below that which points to the "javaw" executable of the JDK on your machine.
	Here is a detailed explanation how to configure the JVM in the ini file: https://wiki.eclipse.org/Eclipse.ini

	Double-click SpringToolSuite4.exe to run it.  Choose a new directory for your workspace, or just select the default workspace it suggests.


7.  Install the Buildship Eclipse plugin for Gradle integration.
	- In STS, go to Help->Eclipse Marketplace and in the Find textbox type "buildship".  "Buildship Gradle Integration" should appear.
	- Click the "Install" button, accept the licenses, and restart STS when prompted.


8.  Install the exercises.
	Extract the file crs517.zip to C:\ or the destination of your choice (now referred to as <CRS517_HOME>).
	NOTE: if you do not unzip it into C:\ (the c: root directory), you will need to edit ALL the tomcat xml configuration files you installed in step 2, modifying the path in the docBase attribute of the Context XML element to your path.  These are the files in <TOMCAT_HOME>\conf\Catalina\localhost


9.  In STS click File->Import then select Gradle->Existing Gradle Project.
	- Click Next twice to get to the Import Gradle Project screen.
	- Browse to the <CRS517_HOME>\sourcecode directory and click Next till you get to the Finish (accepting the defaults).
	- Gradle will then download all the dependencies and compile the valid classes (the solutions should compile, but many of the exercises contain deliberately incomplete code).

	
10. Copy the runtime JARs to Tomcat.
	You can simply extract all the files from the runtime-libraries.zip on this CD to your <TOMCAT_HOME>\lib directory.

	Alternatively, you can use Gradle to export these dependencies for you.  To do this, in STS, go to the "Gradle Tasks" View (it should be showing already in one of the tabs on the right-side panel).
	- If you don't see an "other" folder under the "sourcecode" root node, go to the View Menu (the triangle on the top right) and select "Show All Tasks".
	- Expand "other" and double-click "exportRtLibs".  You should see the JAR files in the <CRS517_HOME>\sourcecode\libs\runtime directory.
	- Move all those files to your <TOMCAT_HOME>\lib directory.

	
11. Test that all is ok by starting Tomcat and opening a browser.  Enter the URL http://localhost/rainforest and you should see the rainforest Web application running.

Tomcat can be started from the command prompt from TOMCAT_HOME\bin and running startup.bat or if you installed it as service from the services console on Windows.


12.  (Optional) The Javadoc for the exercise solutions is already included in the crs517.zip, but if you ever need to generate it:.
	- Go to the "Gradle Tasks" View (see step 10).
	- Under the "sourcecode" root node, expand the "documentation" folder, and double-click "javadoc".
