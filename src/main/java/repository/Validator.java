package repository;

public class Validator {
    public static boolean isValidInput(String letter) {
        if (letter == null || letter.length() != 1) {
            return false;
        }
        char symbol = letter.toLowerCase().charAt(0);
        return (symbol >= 'а' && symbol <= 'я') || symbol == 'ё';
    }
}
