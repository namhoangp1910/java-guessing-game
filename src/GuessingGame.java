
/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: Fall 2024<br>
 *
 * This program runs a guessing game where you must find a secret number
 * between -64 and 64 within 8 tries. The number is always an integer.
 *
 * The best strategy for this game is by guessing the midpoint of the current range, then narrowing the range
 * based on whether the secret number is higher or lower than the guess.
 *
 * Suggested steps to beat the game:
 * 1) First guess: 0
 * 2) If guess < secret number, next guess: 32; if guess > secret number, next guess: -32
 * 3) Try guessing the middle of the range and narrow down from there.
 *
 *  @author Phuong Nam Hoang
 * 	@author Aaryan Mittal
 */
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	/**
	 * The highest and lowest possible guesses.
	 */
	private static final int MAX_POSSIBLE_GUESS = 64;
	private static final int MIN_POSSIBLE_GUESS = -64;

	/**
	 * Holds the player's current guess.
	 */
	int userInput = 0;

	/**
	 * Used to generate the random secret number.
	 */
	private Random randomNumberGenerator = new Random();

	/**
	 * Stores all guesses made by the player.
	 */
	private int[] arrayInput = new int[8];

	/**
	 * Sets each element of the guess array to 100, so we know if a guess is
	 * repeated.
	 */
	public void initializeArray() {
		for (int i = 0; i < arrayInput.length; i++) {
			arrayInput[i] = 100;
		}
	}

	/**
	 * Picks a random number between -64 and 64.
	 */
	public int getRandomNumber() {
		int max = MAX_POSSIBLE_GUESS - MIN_POSSIBLE_GUESS;
		int zeroToMax = randomNumberGenerator.nextInt(max + 1);
		return zeroToMax + MIN_POSSIBLE_GUESS;
	}

	/**
	 * Shows a welcome message and the rules of the game.
	 */
	public void welcomeMessage() {
		System.out.println("=============================================================");
		System.out.println("Welcome to Guess The Number Game!");
		System.out.println();
		System.out.println("Game Rules:");
		System.out.println("1) You have 8 guesses");
		System.out.println("2) If wrong, you get a hint");
		System.out.println("3) Guess between -64 and 64");
	}

	/**
	 * Shows a menu asking if the player wants to play again or quit. The parameter
	 * is: userInput (int)
	 */
	public boolean playMenu(int userInput) {
		System.out.println();
		System.out.println("=============================================================");
		System.out.println("Guess The Number Game");
		System.out.println();
		System.out.println("Play Menu");
		System.out.println("1) Enter '1' to play again");
		System.out.println("2) Enter '0' to quit");
		System.out.println();

		userInput = getInput(0, 1);
		if (userInput == 1) {
			return true;
		} else {
			System.out.println("Thank you for playing. Quitting...");
			return false;
		}
	}

	/**
	 * Asks the user for an integer between min and max. Keeps asking until a valid
	 * number is entered. The parameters are: min (int), max (int)
	 */
	public int getInput(int min, int max) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an integer between " + min + " and " + max + ": ");

		while (true) {
			if (keyboard.hasNextInt()) {
				int userInput = keyboard.nextInt();
				if (min <= userInput && userInput <= max) {
					return userInput;
				} else {
					System.out.println("Out of range. Enter a number between " + min + " and " + max + ":");
					keyboard.nextLine();
				}
			} else {
				System.out.println("Invalid input. Enter a number between " + min + " and " + max + ":");
				keyboard.nextLine();
			}
		}
	}

	/**
	 * Checks if the player has guessed this number before. The parameter is:
	 * userInput (int)
	 */
	public boolean checkNumDuplicate(int userInput) {
		for (int i = 0; i < arrayInput.length; i++) {
			if (arrayInput[i] == userInput) {
				System.out.println("You already guessed " + userInput + " on guess #" + (i + 1));
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints all previous guesses. The parameter is: guessCount (int)
	 */
	public void printPreviousAnswer(int guessCount) {
		System.out.print("Previous guesses: ");
		for (int i = 0; i < guessCount; i++) {
			System.out.print(arrayInput[i] + "  ");
		}
		System.out.println();
	}

	/**
	 * Stores the player's guess in the array. The parameters are: guess (int),
	 * index (int)
	 */
	public void storeGuess(int guess, int index) {
		if (index < arrayInput.length) {
			arrayInput[index] = guess;
		}
	}

	/**
	 * Checks if the guess is correct. If not, tells the player if the secret number
	 * is higher or lower. The parameter is: secretNumber (int)
	 */
	public boolean correctNum(int secretNumber) {
		if (userInput < secretNumber) {
			System.out.println("The secret number is greater than " + userInput);
			return false;
		} else if (userInput > secretNumber) {
			System.out.println("The secret number is lower than " + userInput);
			return false;
		} else {
			System.out.println("You guessed the secret number!");
			System.out.println("It was: " + secretNumber);
			return true;
		}
	}

	/**
	 * Runs the main game: 1) Set up guesses 2) Pick a secret number 3) Let player
	 * guess up to 8 times 4) If out of guesses, show the correct number 5) Ask if
	 * they want to play again
	 */
	public boolean playGuessingGame() {
		initializeArray();
		int secretNumber = this.getRandomNumber();
		welcomeMessage();
		boolean guessedCorrectly = false;

		int guessCount = 0;

		while (guessCount < arrayInput.length && !guessedCorrectly) {
			userInput = getInput(-64, 64);

			while (checkNumDuplicate(userInput)) {
				System.out.println("Pick another number.");
				userInput = getInput(-64, 64);
			}

			storeGuess(userInput, guessCount);
			printPreviousAnswer(guessCount);

			guessedCorrectly = correctNum(secretNumber);

			guessCount++;
		}

		if (!guessedCorrectly) {
			System.out.println("You used all guesses. The secret number was: " + secretNumber);
		}

		return playMenu(userInput);
	}
}
