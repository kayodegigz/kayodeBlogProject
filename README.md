# 0x00. QRATE - A blog for online learners. The web application was built with the Java SpringBoot framework.

## 0x00.Table of contents

* [0x01 Introduction](#0x01-Introduction)
* [0x02 Tools_Used](#0x02-Tools_Used)
* [0x03 HOW_TO_USE](#0x03-HOW_TO_USE)
* [0x04 Testing](#0x04-Testing)
* [0x05 Author](#0x05-Author)

## 0x01 Introduction

This project is a blog that solves the problem of online learners(especially beginners) having to search all round the web for resources that will actually help them learn.


The web application will have two sections:
<ul>
  <li>USER SECTION</li>
  <li>ADMIN SECTION</li>
</ul>

The web application will contain the following features:

FOR USERS:
* REGISTRATION
* LOGIN
* NEW POST CREATION
* BLOG VIEW TO SEE ALL POSTS ON THE WEBSITE
* VIEW ALL POSTS MADE BY LOGGED  IN USER
* UPVOTING AND DOWNVOTING POSTS
* MAKE COMMENTS ON EVERY POST

FOR ADMINS:
Admins can perform every action that a normal user can perform, however they can also access the admin dashboard which has the following features:
* MANAGE USERS
* MANAGE POSTS
* MANAGE COMMENTS

This is the landing page you see once you visit the site. You have two choices either to login or signup 
![image](https://user-images.githubusercontent.com/47942099/207154337-01954bed-db28-4e41-885a-ab670d1d2929.png)

### Registration Page

![image](https://user-images.githubusercontent.com/47942099/207155089-a92e048f-b883-4879-8bd3-301072521d7f.png)
All fields are validated from the frontend and backend for null values, too short passwords etc


### Login Page
![image](https://user-images.githubusercontent.com/47942099/207155649-f89c69b8-1204-421b-b7e4-b11f7cc5cfff.png)
The login fields are also validated and authenticated with spring security. If the credentials are not in the DB, authentication fails.


## 0x02 Tools_Used

### FRONTEND
The frontend was built with the following
* HTML5
* CSS BOOTSTRAP
* JAVASCRIPT

### BACKEND
The backend was built with the JAVA SpringBoot Framework
* Spring MVC framework
* Thymeleaf Java template engine
* Spring Data JPA
* Spring Security

### BUILD TOOL
* Maven

### IDEs USED
* VSCode
* Intellij IDEA

### DATABASE USED
* MySQL

### VERSION CONTROL
* GIT

All the development and testing was run over a Windows 11 operating system using the JAVA programming language version 17.

## 0x03 HOW_TO_USE

#### First, let's go over the basic requirements needed to run this web application:
* A modern browser(preferably Google Chrome)
* IntelliJ IDEA(preferred) or any IDE capable of running SpringBoot applications.
* MySQL as the DBMS.
* A database named "qrate" should be created in the DBMS of choice.
*NOTE: MSSQL can also be used as the DBMS of choice, the configuration settings for MSSQL are commented out in the application.properties file(lines 14 - 20), you can uncomment and tweak the credentials to match yours.

#### Next, the repository should be cloned
```bash
git clone https://github.com/kayodegigz/kayodeBlogProject
```

#### Open the `kayodeBlogProject` directory with IntelliJ IDEA or any other IDE of choice:

#### Adjust the configuration settings in the application.properties file to suit the DBMS of choice

#### Create the "qrate" database in the DBMS of choice.

#### Populate the roles table in the DB with ids 1 and 2 with the roles.names column populated with "ROLE_USER" and "ROLE_ADMIN" for ids 1 and 2 respectively.

#### Run the application in the IDE of choice.

#### After the application is successfully running, go to your web browser and type in "localhost:8080"(unless another port has been specified by you)

#### Click on "sign up" on the navbar to register. You can only register as a normal user.

#### Once that is done, proceed to login with the credentials previously entered.

#### After successful login, this page shows:
![image](https://user-images.githubusercontent.com/47942099/207166629-279e90eb-c5e2-4de8-ad43-113a806e56d9.png)

#### A normal user cannot access the admin dashboard

#### You can view all posts made on the site by clicking blog

#### You can also create a post by clicking new post
![image](https://user-images.githubusercontent.com/47942099/207167225-18f67e72-f8cb-410c-b01c-1d83db6d12ec.png)

#### After creating a post, you can view all the posts made by the logged in user by clicking on "My Posts"

#### When a post is being viewed, a section is also provided for making comments.
![image](https://user-images.githubusercontent.com/47942099/207167694-ef7b1e93-4b66-4dda-a04e-a216085b6264.png)

#### Clicking on the logout button in the navbar automatically ends the session of the logged in user and logs them out.


## 0x04 Testing




## 0x05 Author
<details>
    <summary>Kayode Ogunrinde</summary>
    <ul>
    <li><a href="https://github.com/kayodegigz">Github</a></li>
    <li><a href="mailto:kayogunrinde@gmail.com">e-mail</a></li>
    </ul>
</details>
