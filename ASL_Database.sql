-- this is a single line comment in SQL language
Create Database ASL; -- creates database

--
Create Table login(
    id int(5) Not null,
    fName char(10) Not null,
    lName char(10) Not null,
    username char(20) Not null,
    password char(20) Not null,
    email char(30) Not null,
    Primary Key(id)
);

Create Table questions(
    id Integer Not null,
    question Text Not null,
    Primary Key(id)
);

-- correct column used to indicate which of the answers are correct
Create Table answers(
    id Integer Not null,
    questionID Integer Not null,
    userAnswer Text Not null,
    correctAnswer Char(1) Not null,
    Primary Key(id),
    Foreign Key(questionID) References questions(id)
);

Insert into login
Values(1, "Cameron", "Cody", "ccody_1234", "testing", "ccody_1234@test.com"),
      (2, "Ryan", "Miller", "rmiller_1025", "TeStiNg", "rmiller_1025@test.com"),
      (3, "Mayvin", "LastName", "msomething_9999", "TESTING", "msomething_9999@test.com"),
      (4, "Omar", "LastName", "osomething_5566", "te5t1ng", "osomething_5566@test.com");

Insert into questions
Values(1, "Which image stands for the letter 'A'?");

Insert into answers
Values(1, 1, "A", "B");