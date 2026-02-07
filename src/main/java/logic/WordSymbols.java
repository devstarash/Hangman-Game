package logic;

import java.util.LinkedHashSet;
import java.util.Set;

public class WordSymbols {
    private static final String EMPTY_LETTER_SYMBOL = "_";
    private final String secretWord;
    private final StringBuilder guessedWord;
    private final Set<Character> usedLetters = new LinkedHashSet<>();
    private boolean isWon = false;

    public WordSymbols(String word) {
        this.secretWord = word;
        guessedWord = new StringBuilder("_".repeat(word.length()));
    }

    public boolean hasBeenUsed(char letter) {
        return usedLetters.contains(letter);
    }

    public void registerLetter(char letter) {
        usedLetters.add(letter);
    }


    public boolean isCorrectGuess(char letter) {
        if (secretWord.indexOf(letter) == -1) {
            return false;
        }
        openLetters(letter);
        checkWin();
        return true;
    }

    public String getUsedLetters() {
        return usedLetters.toString();
    }

    private void openLetters(char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessedWord.setCharAt(i, letter);
            }
        }
    }

    private void checkWin() {
        if (guessedWord.indexOf(EMPTY_LETTER_SYMBOL) == -1) {
            isWon = true;
        }
    }

    public String getGuessedWord() {
        return guessedWord.toString();
    }

    public boolean isWon() {
        return isWon;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
