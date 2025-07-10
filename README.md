# Java Command-Line Guessing Game

This is a simple number guessing game implemented in Java for the command line. The player has a limited number of attempts to guess a secret integer within a specified range. This project was developed as an assignment for an introductory computer science course (CS1A).

## Features

-   **Random Number Generation**: A secret integer is randomly generated between -64 and 64 for each new round.
-   **Limited Attempts**: The player has 8 guesses to find the secret number.
-   **User Input Validation**: The program validates that user input is a valid integer and handles non-numeric or out-of-range entries gracefully.
-   **Duplicate Guess Prevention**: The game tracks previous guesses and prevents the player from wasting an attempt on a number they have already tried.
-   **Helpful Hints**: After each incorrect guess, the game provides a hint, telling the player whether the secret number is higher or lower.
-   **Play Again**: Once a round is over (win or lose), the player is given the option to play another round or quit the application.

## How to Compile and Run

This project can be compiled and run from any standard terminal or command prompt.

### Prerequisites

-   Java Development Kit (JDK) 8 or higher.

### Compilation

Navigate to the source code directory (`src`) and run the `javac` command:

```bash
cd src
javac Game_Program.java GuessingGame.java

Execution
Once compiled, run the main program from the src directory:

java Game_Program

Running the Tests
This project includes a suite of JUnit tests to verify the functionality of the GuessingGame class.

Prerequisites
JUnit 4 library (.jar file) must be in your classpath.

Compilation
Compile the test files along with the source files:

# Make sure you are in the src directory
# For macOS/Linux
javac -cp ".:/path/to/junit-4.13.2.jar:/path/to/hamcrest-core-1.3.jar" *.java

# For Windows
javac -cp ".;C:\\path\\to\\junit-4.13.2.jar;C:\\path\\to\\hamcrest-core-1.3.jar" *.java

Execution
Run the test suite:

# For macOS/Linux
java -cp ".:/path/to/junit-4.13.2.jar:/path/to/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore AllTests

# For Windows
java -cp ".;C:\\path\\to\\junit-4.13.2.jar;C:\\path\\to\\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore AllTests
