package logic;

import repository.Validator;
import ui.HangmanDrawer;
import repository.WordReader;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите 'start', чтобы начать игру или 'stop' чтобы выйти из приложения");
            String choice = scanner.nextLine();
            if (choice.equals("start")) startGame();
            else if (choice.equals("stop")) break;
            else System.out.println("Повторите выбор");
        }


    }

    private static void startGame() {
        Counter counter = new Counter();
        Word word = new Word(new WordReader("words.txt").getRandomWord()); //Загадывается слово
        System.out.println("Попытайтесь угадать слово, удачи!");
        System.out.println(word.getGuessedWord()); //Маска слова
        while (true) {
            String letter;
            do {
                System.out.println("Введите букву");
                letter = scanner.nextLine();
            }
            while (!Validator.validInput(letter)); // Проверка ввода верной буквы
            char let = letter.toLowerCase().charAt(0);
            if (word.checkLetter(let)) {
                System.out.println(word.getGuessedWord());
                if (word.isWon()) {
                    System.out.println("Вы выиграли!");
                    break;
                } else {
                    System.out.println("Вы успользовали: " + word.getLetterUsed());
                }

            } else {
                counter.increase();
                System.out.println(HangmanDrawer.getHangmanState(counter.getCount())); //Печать виселицы
                System.out.println("Вы ошиблись. Осталось попыток: " + (6 - counter.getCount()));
                System.out.println("Вы успользовали: " + word.getLetterUsed());
                if (counter.getCount() == 6) {
                    System.out.println("Увы! Вы проиграли.");
                    System.out.println("Загаданное слово: " + word.getWord());
                    break;
                }

            }
        }


    }
}
