# AWSWebServiceApplication

# Project name
WebService with AWS and MYSQL

## Description
This is a AWSWebService application with CRUD function that is connected with MYSQL database to store books.
To work with the CRUD function you need to use postman and MYSQL. 


## In AWS, I have created a pipeline consisting of three stages: source, build, and deploy.
- Source: This stage is linked to my GitHub repository. When code is pushed to GitHub, an event is triggered and captured by AWS CodePipeline.
- Build: This stage retrieves the code to determine if any compilation is needed, performs unit tests, and handles files. It checks what needs to be done before distribution.
- Deploy: This stage activates and updates the application from Java to the AWS environment. It also creates the endpoint that I will use to call my database via AWS.

This pipeline automates the process of fetching, building, and deploying my application from GitHub to AWS, ensuring smooth and efficient deployment of updates to my application.

# Url for postman:
## Add book
Post method

http://webenviromentvikram-env.eba-zkmmwpce.eu-north-1.elasticbeanstalk.com/books/

## Get all books
Get method

http://webenviromentvikram-env.eba-zkmmwpce.eu-north-1.elasticbeanstalk.com/books/

## Get one book with ID
Get method

http://webenviromentvikram-env.eba-zkmmwpce.eu-north-1.elasticbeanstalk.com/books/{id}

## Update book with book ID
Patch method

http://webenviromentvikram-env.eba-zkmmwpce.eu-north-1.elasticbeanstalk.com/books/{id}

## Delete book with book ID
Delete method

http://webenviromentvikram-env.eba-zkmmwpce.eu-north-1.elasticbeanstalk.com/books/{id}

The payload need to be in json format for exemple
{
"title": "Pippi Långström",
"author": "Astrid Lindgren"
}

## Installation
- Javaversion: 21 java version
- Download and install MySQL Workbench
- Download and install Postman
- Download and install IntelliJ
- Clone the project on GitHub and open it in IntelliJ.
- Run the program from the Main class and the menu will start working.

## License
MIT License