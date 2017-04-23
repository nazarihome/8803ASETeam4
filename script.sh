#!/usr/bin/expect -f

spawn scp README.md nazarihome@104.198.152.153:~/README.md 
expect "password:"
send "mohMOH13579\r"