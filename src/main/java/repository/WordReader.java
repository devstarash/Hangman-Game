package repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordReader {
    private final List<String> words;
    private static final Random RANDOM = new Random();

    public WordReader(String path) {
        try {
            words = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла по пути: " + path);
        }
    }

    public String getRandomWord() {
        int position = RANDOM.nextInt(0, words.size());
        return words.get(position).toLowerCase();
    }
}
