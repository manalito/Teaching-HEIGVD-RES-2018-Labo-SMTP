#Teaching-HEIGVD-RES-2018-Labo-SMTP

Autor: Olivier Liechti, Siu Aurélien, Flückiger Nathan

## Description of the Repository

This reppository has been created for an exercice in a university, the subject is to create a SMPT server, and to create a class to send random spam.

The random spam is created with the help of a bunch of class:
* PrankGenerator class who choose the victims and the messages in random and create a prank
* **Prank class who represent a spam email to send and the people to who will be send
* **ConfigManager class who read a config.properties files and two other files (messages.utf8, victims.utf8) and give an acces to the information
* **Person, Mail, Group are three class to help the implementation and the use of the data
* **SmtpClient is use to connect to a mockmock server and send the Prank

The project is stocked on a docker container to help with the implementation of the project on other computer, the mockmock server .jar can be found in the docker


## Config the prank generator

To use the prank generator, you must change the data of three files:

* **Messages.utf8, in this file, you must write all the diffrent messages that you will use in the prank, to use it properly, you have to create a message this way
*  *Put a "Subject: My subject" in the mail, if you don't want a subject put it this way "Subject:"
*  *Write the body of your message
*  *End the message with a line with only "" in it
*  ***The withe line (line with nothing) are not taken in the mail

* **victims.utf8, in this file you must write all the adresses to prank, those adresses will be split in the number of group you ask for in config.properties so get the number of adresses at least equal to the number of group
*  ***The way to write the emails to prank are this way ONE EMAIL PER LINE

If the program does not work correctly you may have fail one of this step.


## Docker setup
* To be able to run the server, you have to build and run the docker  
Here is the instruct to setup and run the server on a Linux operating system  
At first be sure you are on the root directory of the project
You will see the _Dockerfile_

  Open a terminal and type the following commands:

  This will build your docker image with the name _"smtp-server"_: 

sudo docker build -t smtp-server   
 
 This will run the docker containing the smtp server with port 2525 used for the SMTP protocol 
 and the port 8282 for access to the web interface of the MockMock server :
 
sudo docker run -p 8282:8282 -p 2525:2525 smtp-server