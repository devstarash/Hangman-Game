package logic;

public class Word {
    private char[] word;
    private StringBuilder guessedWord = new StringBuilder();
    private StringBuilder letterUsed = new StringBuilder();
    private boolean isWon = false;
    private int count = 0;

    public Word(String word) {
        this.word = word.toCharArray();
        guessedWord.append("_".repeat(word.length()));
    }

    public String getGuessedWord() {
        return guessedWord.toString();
    }

    public boolean checkLetter(char letter) {
        boolean result = false;
        if (letterUsed.toString().contains(String.valueOf(letter))) {
            System.out.println("Эта буква уже была использована.");
            return true;
        } else {
            letterUsed.append(letter).append(' ');
        }
        for (int i = 0; i < word.length; i++) {
            if (letter == word[i]) {
                guessedWord.setCharAt(i, word[i]);
                count++;
                result = true;
                if (!guessedWord.toString().contains("_")) {
                    isWon = true;
                }

            }
        }
        return result;

    }

    public String getLetterUsed() {
        return letterUsed.toString();
    }

    public boolean isWon() {
        return isWon;
    }

    public String getWord() {
        StringBuilder word = new StringBuilder();
        for (Character ch : this.word) word.append(ch);
        return word.toString();
    }
}
