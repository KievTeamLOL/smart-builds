# smart-builds
Smart Builds is easy way to create, find and share League of Legends builds. Also, you can download them and install in game in few clicks!


I. To run application on your local machine you require the following software:
1. <a href=”https://java.com/download”> Java VM </a>
2. <a href=http://tomcat.apache.org/>Apache Tomcat Server</a> (<a href="https://tomcat.apache.org/tomcat-8.0-doc/setup.html">How to setup?</a>)
II. 
1. Download a build file SmartBuilds-1.0-SNAPSHOT.war from repository
2. Copy WAR file to TOMCAT_HOME/webapps/.
	The value of TOMCAT_HOME will depend on where you have Tomcat
installed.  It should be the root directory of your installation (i.e.
right above bin, conf, etc).

There are a number of ways to set TOMCAT_HOME.  One is to just set it in
your shell: export TOMCAT_HOME=/usr/share/tomcat.  Another is to add
this line to $CCM_HOME/conf/envvars: TOMCAT_HOME=/usr/share/tomcat

3. Start Tomcat
3. Open your web-browser and go to link <a href="http://localhost:8084/SmartBuilds/">http://localhost:8084/SmartBuilds/</a> 
4. Enjoy!
