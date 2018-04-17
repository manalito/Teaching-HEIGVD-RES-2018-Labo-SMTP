# Teaching-HEIGVD-RES-2018-Labo-SMTP

## Objectives

In this lab, you will develop a client application (TCP) in Java. This client application will use the Socket API to communicate with a SMTP server. The code that you write will include a **partial implementation of the SMTP protocol**. These are the objectives of the lab:

* Make practical experiments to become familiar with the **SMTP protocol**. After the lab, you should be able to use a command line tool to **communicate with a SMTP server**. You should be able to send well-formed messages to the server, in order to send emails to the address of your choice.

* Understand the notions of **test double** and **mock server**, which are useful when developing and testing a client-server application. During the lab, you will setup and use such a **mock server**.

* Understand what it means to **implement the SMTP protocol** and be able to send e-mail messages, by working directly on top of the Socket API (i.e. you are not allowed to use a SMTP library).

* **See how easy it is to send forged e-mails**, which appear to be sent by certain people but in reality are issued by malicious users.

* **Design a simple object-oriented model** to implement the functional requirements described in the next paragraph.


## Functional requirements

Your mission is to develop a client application that automatically plays pranks on a list of victims:

* The user should be able to **define a list of victims** (concretely, you should be able to create a file containing a list of e-mail addresses).

* The user should be able to **define how many groups of victims should be formed** in a given campaign. In every group of victims, there should be 1 sender and at least 2 recipients (i.e. the minimum size for a group is 3).

* The user should be able to **define a list of e-mail messages**. When a prank is played on a group of victims, then one of these messages should be selected. **The mail should be sent to all group recipients, from the address of the group sender**. In other words, the recipient victims should be lead to believe that the sender victim has sent them.


## Example


## Deliverables

You will deliver the results of your lab in a GitHub repository. 

Your repository should contain both the source code of your Java project and your report. Your report should be a single `README.md` file, located at the root of your repository. The images should be placed in a `figures` directory.

Your report MUST include the following sections:

* **A brief description of your project**: if people exploring GitHub find your repo, without a prior knowledge of the RES course, they should be able to understand what your repo is all about and whether they should look at it more closely.

* **Instructions for setting up a mock SMTP server (with Docker)**. The user who wants to experiment with your tool but does not really want to send pranks immediately should be able to use a mock SMTP server. For people who are not familiar with this concept, explain it to them in simple terms. Explain which mock server you have used and how you have set it up.


## Docker setup
* To be able to run the server, you have to build and run the docker  
Here is the instruct to setup and run the server on a Linux operating system  
At first be sure you are on the root directory of the project
You will see the _Dockerfile_

	Open a terminal and type the following commands:

	This will build your docker image with the name **_"smtp-server"_**: 

`sudo docker build -t smtp-server`   
 
 This will run the docker containing the smtp server with **port 2525 used for the SMTP protocol **
 and the **port 8282 for access to the web interface** of the MockMock server :
 
`sudo docker run -p 8282:8282 -p 2525:2525 smtp-server`

* **Clear and simple instructions for configuring your tool and running a prank campaign**. 
If you do a good job, an external user should be able to clone your repo, edit a couple of files and send a batch of e-mails in less than 10 minutes.

In addition, your report SHOULD include (i.e. you will not have penalties if you don't provide the info, but if you want to add this project to your portfolio, it is worth doing it):

* **A concise description of your implementation**: document the key aspects of your code. It is probably a good idea to start with a class diagram. Decide which classes you want to show (focus on the important ones) and describe their responsibilities in text. It is also certainly a good idea to include examples of dialogues between your client and a SMTP server (maybe you also want to include some screenshots here).









