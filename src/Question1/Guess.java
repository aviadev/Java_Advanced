package Question1;
/**
 * Created by Aviad on 23/09/2015 Maman11
 */
public class Guess
{

private String _guessString;
private int _bulls, _hits;

protected Guess(String guess, int bulls, int hits)
	{
		_guessString = guess;
		_bulls = bulls;
		_hits = hits;
	}

protected String getGuessString() {return _guessString;}

public String toString()
	{
		return "Guess: " + _guessString + "\t\t" + "Bulls: " + _bulls + "\t\t" + "Hits: " + _hits;
	}
}
