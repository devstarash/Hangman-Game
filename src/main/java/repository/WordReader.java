package repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordReader {
    private final List<String> words;

    public WordReader(String path) {
        try {
            words = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getRandomWord() {
        int position = (int) (Math.random() * words.size());
        return words.get(position);

    }


}
