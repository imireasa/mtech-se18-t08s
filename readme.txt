1. Configure your properties in the build.xml the following will need to be replaced
	- <property name="tomcat_home" value="/Users/angdao/PS/application/apache-tomcat-6.0.32" />
	- <property name="url" value="http://localhost:8080/manager" />
	- <property name="username" value="sadmin" />
	- <property name="password" value="admin" />

2. In eclipse's menu, 'Window' > Preferences' > 'Ant' > 'Runtime', in the 'Classpath' tab, select 'Ant Home Entries (Default)', 
then click on 'Add External JARs' button. Look for 'catalina-ant.jar' from your tomcat installation/lib.

3. Setup your users in tomcat. Edit the file 'tomcat installation/conf/tomcat-users.xml'. Add the following just above the 
tag </tomcat-users>

<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<role rolename="manager-jmx"/>
<role rolename="manager-status"/>
<user username="admin" password="admin" roles="manager-gui"/>
<user username="scriptadmin" password="admin" roles="manager-script"/> 

This setting is required for 6.0.30 and above.

4. Setup your ANT env by putting your ANT_HOME/bin into your PATH. for example : 
set PATH=%PATH%;D:\ant\bin

========================================================================
How to use:

For initial deployment (no deployments done before), exec
ant deploy
at the command prompt at the place where the build.xml is

for subsequent deployment exec
ant reload
