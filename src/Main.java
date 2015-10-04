import java.awt.*;
import java.util.Scanner;

public class Main
{
public static void main(String[] args)
{
	boolean anotherGame = true;
	boolean foundNum = false;
	Guess gameLogic = new Guess();
	Scanner scanner = new Scanner(System.in);
	gameLogic.sayLine("Hello, I want to play a GAME!\n", SystemColor.cyan);
	//System.out.println("Hello, I want to play a GAME!\n");
	while (anotherGame)
	{
		gameLogic.startAgain();
		gameLogic.sayLine("Game is generating new number...\n", SystemColor.cyan);
		//System.out.println("Game is generating new number...\n");
		gameLogic.randomNumberGenerator();
		System.out.println("Random Num: " + gameLogic.getRandomNum());
		gameLogic.sayLine("Please enter your guess (4 digits):\n", SystemColor.yellow);
		//System.out.println("Please enter your guess (4 digits):");
		String userInput = scanner.nextLine();
		while (!foundNum)
		{
			while (!gameLogic.isValidString(userInput, true))
			{
				userInput = scanner.nextLine();
			}
			foundNum = gameLogic.isGuess(userInput);
			if (foundNum) break;
			gameLogic.getHitsBulls(userInput);
			gameLogic.printGuess();
			gameLogic.sayLine("\nPlease enter a new guess:\n", SystemColor.yellow);
			userInput = scanner.nextLine();
		}
		gameLogic.showResults();
		gameLogic.sayLine("\nWould you like to play another game? Y/N\n", SystemColor.cyan);
		// System.out.println("\nWould you like to play another game? Y/N");
		String str = scanner.nextLine().toLowerCase();
		anotherGame = str.equals("y");
	}
	gameLogic.sayLine("\nThank you for playing!\nPress any key to exit...", SystemColor.cyan);
	//System.out.println("\nThank you for playing!\nPress any key to exit...");
}
}


