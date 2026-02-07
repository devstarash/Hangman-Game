package repository;

public class Validator {
    public static boolean validInput(String letter) {
        if (letter.length() != 1) return false;
        char let = letter.toLowerCase().charAt(0);
        return let >= 'а' && let <= 'я';

    }
}
