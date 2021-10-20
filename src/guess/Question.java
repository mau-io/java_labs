package guess;

import java.util.Scanner;

public class Question {
    private Scanner reader;
    public String secretWord;
    public int guessesCount;

    Question(String secretWord, int guessesCount) {
        this.reader = new Scanner(System.in);
        setGuessesCount(guessesCount);
        setSecretWord(secretWord);
    }

    public void setGuessesCount(int guessesCount) {
        this.guessesCount = guessesCount;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord.toLowerCase();
    }

    public void init() {
        String dashedWord = createDashedWord(secretWord);

        System.out.println("You have " + guessesCount + " tries.");
        System.out.println("Here's the question: \n" + dashedWord + " (" + secretWord.length() + ")");

        loadGuess();
    }

    private void loadGuess() {
        boolean iterated = false;
        int countWrong = 0;
        String temp = "";
        while (guessesCount > 0) {

            boolean correctGuess = false;
            System.out.print("Guess a letter: ");
            String guess = this.reader.nextLine();

            for (int i = 0; i < secretWord.length(); i++) {

                boolean isCorrectLetter = guess.equals(Character.toString(secretWord.charAt(i)));
                if (isCorrectLetter) {
                    correctGuess = true;

                    if (!iterated)
                        temp += Character.toString(secretWord.charAt(i));
                    else {
                        String holder = Character.toString(
                                temp.charAt(i)).replace("-", guess);
                        temp = temp.substring(0, i) + holder +
                                temp.substring(i + 1, temp.length());
                    }

                } else {
                    if (!iterated) {
                        temp += "-";
                    }
                }

            }

            iterated = true;

            if (correctGuess) {
                System.out.println("The word contains the letter " + guess + ".");
            } else {

                if(guess.length() == 1) {
                    guessesCount--;
                    countWrong++;
                }

                printWrong(guess, countWrong);
            }

            System.out.println(temp);

            if (temp.equals(secretWord)) {
                printWin();
                break;
            }
        }

        if (guessesCount <= 0) {
            printLose();
        }
        this.reader.close();
    }

    private void printWrong(String guess, int countWrong) {
        System.out.println("The word does not contain the letter " + guess + ".");
        System.out.println(
            "You have (" +
            countWrong +
            ") guesses wrong letter."
        );
    }

    private void printWin() {
        System.out.println(
            "You Win!  \n" +
            "You have '" + secretWord + "' guessed correctly!"
        );
    }

    private void printLose() {
        System.out.println(
            "You lose! \n" +
            "The correct word was " +
            "\"" + secretWord + "\"."
        );
    }

    private static String createDashedWord(String word) {
        return word.replaceAll("[a-zA-Z]", "_");
    }
}
