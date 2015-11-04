package Question1;
import java.util.Scanner;

public class Main
{

public static void main(String[] args)
	{
		boolean playAnotherGame = true;

		GameLogic gameLogic = new GameLogic();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello, I want to play a GAME!\n");

		while (playAnotherGame)
			{
			boolean foundNum = false;
			gameLogic.startNewGame();
			System.out.println("Game is generating new number...\n");
			gameLogic.generateNewRandomNumber();
			//System.out.println("Random Num: " + gameLogic.getRandomNumber());
			System.out.println("Please enter your guess (4 digits):\n");
			String userGuess = scanner.nextLine();
			while (!foundNum)
				{
				while (!gameLogic.isValidString(userGuess, true))
					{
					userGuess = scanner.nextLine();
					}
				foundNum = gameLogic.isGuess(userGuess);
				if (foundNum) break;
				gameLogic.getHitsAndBulls(userGuess);
				System.out.print(gameLogic.toString());
				System.out.println("\nPlease enter a new guess:\n");
				userGuess = scanner.nextLine();
				}
			gameLogic.showScores();
			System.out.println("\nWould you like to play another game? Y/N\n");

			String playAnotherGameInput = scanner.nextLine().toLowerCase();
			playAnotherGame = playAnotherGameInput.equalsIgnoreCase("y");
			}
		System.out.println("\nThank you for playing!\n");
	}
}


