package ui;


public class HangmanDrawer {
    public enum HangmanState {
        HEAD("""
                  +---+
                  |   |
                  O   |
                      |
                      |
                      |
                ========="""),

        BODY("""
                  +---+
                  |   |
                  O   |
                  |   |
                      |
                      |
                ========="""),

        LEFT_ARM("""
                  +---+
                  |   |
                  O   |
                 /|   |
                      |
                      |
                ========="""),

        RIGHT_ARM("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                      |
                      |
                ========="""),

        LEFT_LEG("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                 /    |
                      |
                ========="""),

        RIGHT_LEG("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                 / \\  |
                      |
                =========""");

        private final String art;

        HangmanState(String art) {
            this.art = art;
        }

        @Override
        public String toString() {
            return this.art;
        }
    }

    public static String drawHangmanState(int errors) {
        return HangmanState.values()[errors - 1].toString();
    }
}