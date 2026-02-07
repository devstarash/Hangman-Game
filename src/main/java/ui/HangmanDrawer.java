package ui;

public class HangmanDrawer {
    private static final String[] BODY_PARTS = {"O", "|", "/", "\\", "/", "\\"};

    public static String getHangmanState(int errors) {
        StringBuilder person = new StringBuilder();
        String[] current = new String[6];
        for (int i = 0; i < 6; i++) {
            current[i] = (errors > i) ? BODY_PARTS[i] : " ";
        }
        person.append("  +---+\n")
                .append("  |   |\n")
                .append(String.format("  %s   |\n", current[0]))
                .append(String.format(" %s%s%s  |\n", current[2], current[1], current[3]))
                .append(String.format(" %s %s  |\n", current[4], current[5]))
                .append("      |\n")
                .append("=========");
        return person.toString();

    }

}