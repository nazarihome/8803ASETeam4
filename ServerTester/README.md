# How to use this

This is a test unit using JUnit Test Case. It reads tests from login.txt and register.txt and uses http connection to connect to server and test its APIs. Reads the address and port from config.txt.

RegisterTest.java is testing register API and LogInTest.java is testing Login API.  

The test files can be modified. Formats are as follows:

RegisterTest:
[email] [password] [name] [exist/notexist](user exists or not in DB)

RegisterTest:
[email] [password] [success/fail](expected outcome)

# How to use this

this is an eclipse maven project. so you can build it:
1.by eclipse
2.mvn test
the 'mvn test' build has been tested on an ubuntu machine. When it passes all tests, it shows test was successful.

#How does CI work?

We use codeship. There are one server for testing and one for deplyment. if test passes, script automatically transfers file to deployment server.



