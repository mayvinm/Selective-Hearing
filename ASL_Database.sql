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
-- sql code for inserting values into the table is in the java code because it compares the submitted answer to the correct answer that is in the database
Create Table compare(
    tableID int(5) Not Null AUTO_INCREMENT,
    value varchar(100) Not Null,
    Primary Key(tableID)
);
-- sql code for inserting values into the table is in the java code because it uses the choices the user picks
CREATE TABLE submittedAnswers(
    tableID INT(5) NOT NULL AUTO_INCREMENT, 
    submitAnswer VARCHAR(100) NOT NULL, 
    PRIMARY KEY(tableID)
);
-- this table holds the correct answers for the questions
Create Table answers(
    tableID int(5) Auto_Increment Not null,
    questionID int(5) Not null,
    correctAnswer Text Not Null,
    Primary Key(tableID),
    Foreign Key(questionID) References questions(tableID)
);
-- intial users, new users are added through the application
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
      (6, "Greeting", "What greeting is this?"),
      (7, "Greeting", "This means 'Please'. True or False?"),
      (8, "Greeting", "This means 'You're welcome'. True or False?"),
      (9, "Greeting", "Does this mean 'Thank you' or 'Hello'?"),
      (10, "Greeting", "What greeting is being signed?"),
      (11, 'Food', 'What is this fruit?'), 
      (12, 'Food', 'What is the name of the food shown?'), 
      (13, 'Food', 'This is an orange. True or False?'), 
      (14, 'Food', 'Is the food/fruit shown a: strawberry, watermelon, or chicken?'), 
      (15, 'Food', 'What is the man signing?'), 
      (16, 'Alphabet', 'What letter is this?'), 
      (17, 'Alphabet', 'What letter is this?'), 
      (18, 'Alphabet', 'Is this the letter U or the number 2?'), 
      (19, 'Alphabet', 'This is the letter N. True or False?'), 
      (20, 'Alphabet', 'What letter is this?');

Insert into answers
Values(1, 1, "10"),
      (2, 2, "False"),
      (3, 3, "1"),
      (4, 4, "True"),
      (5, 5, "C"),
      (6, 6, "Hello"), 
      (7, 7, "False"), 
      (8, 8, "True"), 
      (9, 9, "Thank you"), 
      (10, 10, "Please"),
      (11, 11, 'Cherry'), 
      (12, 12, 'Eggs'), 
      (13, 13, 'True'), 
      (14, 14, 'Watermelon'), 
      (15, 15, 'Meat'), 
      (16, 16, 'A'), 
      (17, 17, 'Z'), 
      (18, 18, 'U'), 
      (19, 19, 'True'), 
      (20, 20, 'H');
