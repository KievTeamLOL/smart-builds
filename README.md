<h2>HOW TO START</h2>
<ul>
<li> <b> To run application on your local machine you require the following software:</b>
<ol type='1'>
<li> <a href=”https://java.com/download”> Java VM </a>
<li> <a href=http://tomcat.apache.org/>Apache Tomcat Server</a> (<a href="https://tomcat.apache.org/tomcat-8.0-doc/setup.html">How to setup?</a>)
</ol>
<li> <b> For run application:</b>
<ol type='1'>
<li> Download a build file SmartBuilds-1.0-SNAPSHOT.war from repository
<li> Copy WAR file to TOMCAT_HOME/webapps/. <br>
	The value of TOMCAT_HOME will depend on where you have Tomcat
installed.  It should be the root directory of your installation (i.e.
right above bin, conf, etc).
<br>
There are a number of ways to set TOMCAT_HOME.  One is to just set it in
your shell: export TOMCAT_HOME=/usr/share/tomcat.  Another is to add
this line to $CCM_HOME/conf/envvars: TOMCAT_HOME=/usr/share/tomcat
<br>
<li>Start Tomcat
<li> Open your web-browser and go to link <a href="http://localhost:8084/SmartBuilds/">http://localhost:8084/SmartBuilds/</a> 
<li> Enjoy!
</ol>
</ul>
