package Advanced.StreamsFilesAndDirectories.Ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {

        Path pathToWords = Path.of("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\words.txt");

        LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();

        List<String> allLinesWords = Files.readAllLines(pathToWords);
        allLinesWords.forEach(line -> Arrays.stream(line.split("\\s+")).forEach(word -> wordsCount.put(word, 0)));

        Path pathText = Path.of("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\text.txt");
        List<String> textAllLines = Files.readAllLines(pathText);
        for (String line : textAllLines) {
            String[] wordInLine = line.split("\\s+");
            Arrays.stream(wordInLine).forEach(word -> {
                if (word.contains(",")) {
                    word = word.replaceAll(",", "");
                    int currentCount = wordsCount.get(word);
                    wordsCount.put(word, currentCount + 1);
                }
            });
        }

        wordsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        PrintWriter writer = new PrintWriter("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\countWords.txt");
        wordsCount.entrySet().forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}

