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
        boolean firstIteration = true;
        int countWrong = 0;
        String temp = "";

        while (guessesCount > 0) {

            System.out.print("Guess a letter: ");
            String letter = this.reader.nextLine();
            boolean correctGuess = false;

            for (int i = 0; i < secretWord.length(); i++) {

                boolean isCorrectLetter = letter.equals(Character.toString(secretWord.charAt(i)));

                if (isCorrectLetter) {
                    correctGuess = true;

                    if (firstIteration) {
                        temp += Character.toString(secretWord.charAt(i));
                    }
                    else {
                        temp = temp.substring(0, i) +
                                letter +
                                temp.substring(i + 1, temp.length());
                    }

                }

                if(!isCorrectLetter && firstIteration) {
                    temp += "-";
                }
            }

            firstIteration = false;

            if (correctGuess) {
                System.out.println("The word contains the letter " + letter + ".");
            } else {

                if(letter.length() == 1) {
                    guessesCount--;
                    countWrong++;
                }

                printWrong(letter, countWrong);
            }

            System.out.println(temp);

            if (temp.equals(secretWord)) {
                printWin();
                break;
            }
        }

        if (guessesCount == 0) {
            printLose();
        }
        this.reader.close();
    }

    private void printWrong(String letter, int countWrong) {
        System.out.println("The word does not contain the letter " + letter + ".");
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
