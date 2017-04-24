# How to build:
this is a eclipse jersey maven project. you can build it by:
1.mvn package
2.using eclipse

#What is it:
it provides three functionality: 
1.login through get
2.register through post 
3.delte a user account through delete

#How to deploy?
We use a google cloud VM server to deploy. export WAR file and put it in tomcat web folder on server

#How does CI work?

We use codeship. There are one server for testing and one for deplyment. if test passes, script automatically transfers file to deployment server.