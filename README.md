
WELCOME
=======
Welcome to the Mule Example Studio REST approaches application 

TESTING
=======

This example uses several differnt approaches to illustrate implementing REST within a Mule application.

Importing this example project into Mule Studio
-----------------------------------------------

1) Clone this git repoistory to a local directory

2) From Mule Studio complete the following steps:
	- File > IMPORT
	- Select "Mule > Mule Studio Project from External Location" (click Next)
	- Project Root select local directory from step (1)
	- Click "Finish"

Testing the REST component
--------------------------

1) Start the application from within Mule Studio, by right clicking on the project and selecting 'Run As > Mule Application'

2) Open a command line terminal

3) Change directory 'cd' to the /src/test/resources directory, you will see the 'example-REST-curl-commands-for-testing' file contained in this location.

4) Use the curl commands contined in that file (see step 3) executed from a command line terminal to test each of the relevant rest approaches. 

5) Note: There are configurable parameters that can be found in the /src/main/app/mule-app.properties file
       - When deploying to CloudHub the http.port parameter must be commented out, and the http.path parameter must be set to 'localhost'.

ADDITIONAL RESOURCES
====================
Everything you need to know about getting started with Mule can be found here:
http://www.mulesoft.org/documentation/display/MULE3INTRO/Home

Remember if you get stuck you can try getting help on the Mule user list:
http://www.mulesoft.org/email-lists

Also, MuleSoft, the company behind Mule, offers 24x7 support options:
http://www.mulesoft.com/enterprise-subscriptions-and-support

Enjoy your Mule ride!

The Mule Team
