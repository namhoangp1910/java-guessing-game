/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: Fall 2024<br>
 * 
 * The class Game_Program is to run the Guess The Number game, where the
 * goal is to find the secret number between -64 and 64 within 8 tries. The
 * number must be a whole number. <br>
 *
 * @author Phuong Nam Hoang
 */
public class Game_Program extends Object {
	public static void main(String[] args) {
		GuessingGame guessingGameObject = new GuessingGame(); // feel free to add arguments to the constructor, if it
																// helps...

		boolean playing = true;
		while (playing) {
			playing = guessingGameObject.playGuessingGame();

			/*
			 * Do whatever else you need to in order to: Step 1:figure out if the game
			 * should be played again or that the entire program should quit and Step 2: set
			 * the playing variable accordingly. You MUST have the
			 * guessingGameObject.playGuessingGame() method return something, so you will
			 * have a variable capture that return (for example you could use the playing
			 * variable for that) and use that variable to stop or continue the already
			 * written while loop. One example way: if guessingGameObject.playGuessingGame()
			 * == 0 then show a message and quit the game. Remember to adhere to the
			 * "Program Guidelines" module item from the first week of the course, such as
			 * NOT using the break or continue keywords. Do NOT use recursion for this
			 * assignment.
			 */
		}
	}
}
