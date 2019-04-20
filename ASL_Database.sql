-- this is a single line comment in SQL language
Create Database ASL; -- creates database
Create Table login(
    tableID int(5) Auto_Increment Not null,
    fName char(10) Not null,
    lName char(10) Not null,
    username char(20) Not null,
    password char(20) Not null,
    email char(30) Not null,
    Primary Key(tableID),
    Unique(username),
    Unique(email)
);

Create Table questions(
    tableID int(5) Auto_Increment Not null,
    quizName char(12) Not Null,
    question Text Not null,
    Primary Key(tableID)
);

Create Table compare(
    tableID int(5) Not Null AUTO_INCREMENT,
    value varchar(100) Not Null,
    Primary Key(tableID)
);

CREATE TABLE submittedAnswers(
    tableID INT(5) NOT NULL AUTO_INCREMENT, 
    submitAnswer VARCHAR(100) NOT NULL, 
    PRIMARY KEY(tableID)
);

Create Table answers(
    tableID int(5) Auto_Increment Not null,
    questionID int(5) Not null,
    correctAnswer Text, -- null when an image button is not used
    image LONGBLOB, -- null when an image button is used
    Primary Key(tableID),
    Foreign Key(questionID) References questions(tableID)
);

Insert into login
Values(1, "Cameron", "Cody", "ccody_1234", "testing", "ccody_1234@test.com"),
      (2, "Ryan", "Miller", "rmiller_1025", "TeStiNg", "rmiller_1025@test.com"),
      (3, "Mayvin", "LastName", "msomething_9999", "TESTING", "msomething_9999@test.com"),
      (4, "Omar", "LastName", "osomething_5566", "te5t1ng", "osomething_5566@test.com");

Insert into questions
Values(1, "Number", "What number is this?"),
      (2, "Number", "This means '5'. True or False?"),
      (3, "Number", "What number is being signed?"),
      (4, "Number", "This means '7'. True or False?"),
      (5, "Number", "Solve the following problem: __ + 10 = 15"),
      (6, "Greeting", "");

Insert into answers
Values(1, 1, "10", null),
      (2, 2, "False", null),
      (3, 3, "1", null),
      (4, 4, "True", null),
      (5, 5, "C", "C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberFive.jpg");
