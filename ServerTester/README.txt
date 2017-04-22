## How to use this

This is a test unit using JUnit Test Case. It reads tests from login.txt and register.txt and uses http connection to connect to server and test its APIs. Reads the address and port from config.txt.

RegisterTest.java is testing register API and LogInTest.java is testing Login API.  

The test files can be modified. Formats are as follows:

RegisterTest:
[email] [password] [name] [exist/notexist](user exists or not in DB)

RegisterTest:
[email] [password] [success/fail](expected outcome)




