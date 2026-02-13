package logic;

import repository.Validator;
import repository.WordReader;
import ui.HangmanDrawer;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GameSession {
    private static final WordReader WORD_READER = new WordReader("words.txt");
    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
    private static final int MAX_ERRORS = 6;

    public void start() {
        while (true) {
            System.out.println("Введите 'start', чтобы начать игру или 'stop' чтобы выйти из приложения");
            String choice = SCANNER.nextLine().toLowerCase().trim();
            if (choice.equals("start")) {
                play();
            } else if (choice.equals("stop")) {
                break;
            } else {
                System.out.println("Повторите выбор");
            }
        }
    }

    private void play() {
        int errors = 0;
        WordSymbols word = new WordSymbols(WORD_READER.getRandomWord()); //Загадывается слово
        System.out.println("Попытайтесь угадать слово, удачи!");
        while ((errors < MAX_ERRORS) && !word.isWon()) {
            System.out.println("Слово: " + word.getGuessedWord());
            System.out.println("Введите букву: ");
            String input = SCANNER.nextLine();
            if (!Validator.isValidInput(input)) {
                continue;
            }
            char letter = input.toLowerCase().charAt(0);
            if (word.hasBeenUsed(letter)) {
                System.out.println("Эта буква была использована.");
                continue;
            }
            word.registerLetter(letter);
            if (word.isCorrectGuess(letter)) {
                System.out.println("Вы угадали букву.");
            } else {
                errors++;
                System.out.println(HangmanDrawer.drawHangmanState(errors));
                System.out.println("Ошибка. Вы не угадали букву. Осталось попыток: " + (MAX_ERRORS - errors));
            }
            System.out.println("Вы использовали: " + word.getUsedLetters());
        }
        if (word.isWon()) {
            System.out.println("Ура! Вы победили. Слово: " + word.getSecretWord());
        } else {
            System.out.println("Вы проиграли! Слово: " + word.getSecretWord());
        }
    }
}
