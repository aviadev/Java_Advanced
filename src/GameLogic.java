import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by aviad on 23/09/2015 Maman11 Maman11.
 */
class Guess {
    ArrayList<Guess> guessList = new ArrayList<>();
    private String randomNum;
    private String guess;
    private int bulls, hits;

    protected Guess() {

    }

    protected Guess(String _guess, int _bulls, int _hits) {
        guess = _guess;
        bulls = _bulls;
        hits = _hits;

    }


    protected void getHitsBulls(String _guess) {

        int _bulls = 0, _hits = 0;
        for (int i = 0; i < _guess.length(); i++) {
            char currentChar = _guess.charAt(i);
            if (currentChar == randomNum.charAt(i))
                _bulls++;
            else if (randomNum.indexOf(currentChar) != -1)
                _hits++;
        }

        addGuess(_guess, _bulls, _hits);

    }

    protected void clearList() {
        this.guessList.clear();
    }


    protected void addGuess(String _guess, int _bulls, int _hits) {
        guess = _guess;
        bulls = _bulls;
        hits = _hits;
        guessList.add(new Guess(_guess, _bulls, _hits));

    }

    private boolean isUniqueGuess(String _guess, boolean warn) {
        boolean lessThanOne = guessList.stream().filter((item) -> item.guess.equals(_guess)).count() < 1;
        if (warn && !lessThanOne)
            System.out.println("\nInput Error! Guess " + _guess + " is already on the list. Please re-enter.");
        return lessThanOne;


    }


    protected boolean isGuess(String guess) {
        return randomNum.equals(guess);
    }

    protected void randomNumberGenerator() {
        Random random = new Random();
        String tempNum = "";
        for (int i = 0; i < 4; i++) {
            tempNum += String.valueOf(random.nextInt(10));
        }
        if (!isDuplicate(tempNum, false)) {
            randomNum = tempNum;
        } else
            randomNumberGenerator();
    }

    protected boolean isValidString(String s, boolean warn) {

        boolean res = true;
        if (s.length() != 4) {
            res = false;
            if (warn) {
                if (s.length() < 4)
                    System.out.println("\nInput Error! Your guess contained less than 4 digits. Please re-enter");
                else if (s.length() > 4)
                    System.out.println("\nInput Error! Your guess contained more than 4 digits. Please re-enter");
            }
        } else if (isDuplicate(s, warn) || !isUniqueGuess(s, warn))
            res = false;
        return res;
    }

    private boolean isDuplicate(String s, boolean warn) {
        Map<Character, Integer> charMap = new HashMap<>();
        boolean res = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charMap.containsKey(c)) {
                charMap.put(c, 1);
            } else {
                res = true;
                if (warn)
                    System.out.println("\nInput Error! Your guess contained duplicated numbers. Please re-enter");
                break;
            }
        }
        return res;
    }


    public void printGuess() {
        String _guess;
        int _bulls, _hits;
        System.out.println("\nSorry, wrong guess...\n" +
                "Your Guess was: " + this.guess + ", " + " Bull(s): " + this.bulls + ",  " + " Hit(s): " + hits);
        if (guessList.size() > 1) {
            System.out.println("\nPrevious Guesses, Bulls and Hits so far:");
            for (Guess guess : guessList) {
                System.out.println("Guess: " + guess.guess + "\t" + "Bulls: " + guess.bulls + "\t" + " Hits: " + guess.hits);
            }

        }


    }

    public void startAgain() {
        if (guessList.size() > 0 || guessList != null)
            clearList();
    }

    public void showResults() {
        int size = guessList.size();
        if (size == 0)
            sayLine("\nOMG on the first attempt! What are the odds?!?!\n", SystemColor.green);
        else if (size < 3) {
            sayLine("\nGreat guess! Only " + size + " attempts!\n", SystemColor.green);
        } else if (size < 7) {
            sayLine("\nGood guess! " + size + " attempts!\n", SystemColor.green);
        } else sayLine("\nPoor guess... " + size + " attempts...\n", SystemColor.green);

    }

    protected void sayLine(String message, Color systemColor) {

        System.out.printf(message, systemColor);
    }

    public String getRandomNum() {
        return randomNum;
    }
}
