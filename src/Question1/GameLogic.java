package Question1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameLogic
{

private static ArrayList<Guess> _guessList = new ArrayList<>();
private final int MAX_GUESS_SIZE = 4;
private String _randomNum;


/*public String getRandomNumber()
	{
		return _randomNum;
	}*/

public GameLogic()
	{

	}

protected void getHitsAndBulls(String userGuess)
	{
		int bulls = 0, hits = 0;

		for (int i = 0; i < userGuess.length(); i++)
			{
			char currentChar = userGuess.charAt(i);
			if (currentChar == _randomNum.charAt(i)) bulls++;
			else if (_randomNum.indexOf(currentChar) != -1) hits++;
			}
		_guessList.add(new Guess(userGuess, bulls, hits));
	}

protected boolean isGuess(String guess)
	{
		return _randomNum.equalsIgnoreCase(guess);
	}

protected void generateNewRandomNumber()
	{
		Random random = new Random();
		String tempNum = "";
		for (int i = 0; i < MAX_GUESS_SIZE; i++)
			{
			tempNum += String.valueOf(random.nextInt(10));
			}
		if (!isDuplicatedNumbersOnString(tempNum, false))
			{
			_randomNum = tempNum;
			}
		else generateNewRandomNumber();
	}

protected boolean isValidString(String userGuess, boolean warn)
	{
		if (userGuess.length() < MAX_GUESS_SIZE)
			{
			if (warn) System.out.println("\nInput Error! Your guess contained less than 4 digits. Please re-enter:\n");
			return false;
			}
		else if (userGuess.length() > MAX_GUESS_SIZE)
			{
			if (warn) System.out.println("\nInput Error! Your guess contained more than 4 digits. Please re-enter:\n");
			return false;
			}

		else if (!isNumericString(userGuess))
			{
			if (warn)
				System.out.println("\nInput Error! Your guess contained chars other than 4 digits. Please re-enter:\n");
			return false;
			}

		else if (isDuplicatedNumbersOnString(userGuess, warn)) return false;

		else if (isGuessAlreadyOnTheList(userGuess))
			{
			if (warn)
				{
				System.out.println("\nInput Error! Guess " + userGuess + " is already on the list. Please re-enter:\n");
				return false;
				}
			}
		return true;
	}

private boolean isNumericString(String userGuess)
	{
		String digits = "0123456789";
		for (int i = 0; i < userGuess.length(); i++)
			{
			if (!digits.contains(userGuess.substring(i, i + 1))) return false;
			}
		return true;
	}

private boolean isDuplicatedNumbersOnString(String userGuess, boolean warn)
	{
		Map<Character, Integer> charMap = new HashMap<>();

		for (int i = 0; i < userGuess.length(); i++)
			{
			char c = userGuess.charAt(i);
			if (!charMap.containsKey(c))
				{
				charMap.put(c, 1);
				}
			else
				{
				if (warn)
					{
					System.out.println("\nInput Error! Your guess contained duplicated numbers. Please re-enter:\n");
					return true;
					}
				return true;
				}
			}
		return false;
	}

private boolean isGuessAlreadyOnTheList(String guess)
	{
		return _guessList.stream().filter((g) -> g.getGuessString().equals(guess)).count() >= 1;
	}

protected void startNewGame()
	{
		if (_guessList.size() > 0) _guessList.clear();
	}

protected void showScores()
	{
		final int GREAT_GUESS_SCORE = 6;
		final int GOOD_GUESS_SCORE = 11;

		int size = _guessList.size();
		if (size == 0) System.out.println("\nOMG on the first attempt! What are the odds?!?!\n");
		else if (size < GREAT_GUESS_SCORE)
			{
			System.out.println("\nGreat guess! Only " + size + " attempts!\n");
			}
		else if (size < GOOD_GUESS_SCORE)
			{
			System.out.println("\nGood guess! " + size + " attempts!\n");
			}
		else System.out.println("\nPoor guess... " + size + " attempts...\n");
	}

@Override
public String toString()
	{
		System.out.println("\nPrevious Guesses, Bulls and Hits so far:");
		String str = "";
		for (Guess guess : _guessList)
			{
			str += guess.toString() + "\n";
			}
		return str;
	}
}

