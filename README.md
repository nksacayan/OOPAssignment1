# OOPAssignment1
Turn in for CPP OOP class with Professor Sun

SimulationDriver.java:
Contains main method and pilots other classes.

Question.java:
Abstract class that contains base Question implementation.

MultipleSolutionQuestion.java:
Extends Question.java. A question that allows multiple true answers.

SingleSolutionQuestion.java:
Extends Question.java. A question that has only one true answer.

Student.java:
Concrete class that contains specifcations for student objects.

StudentGenerator.java:
Used in SimulationDriver to randomly generate students using the given array of names.

BadQuestionGenerator.java:
Used in SimulationDriver to randomly generate questions, question types, and correct answers
using the given arrays of questions and answers.

VotingService.java:
Contains all submissions by students and the question. Handle statistics and submissions.

Note: Program works but occasionally stalls if student cannot randomly arrive at a valid submission.
