package Advanced.StreamsFilesAndDirectories.Ex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathStr = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathStr));

        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuations = 0;

        for (String line : allLines) {
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if (currentSymbol == ' ') {
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i' || currentSymbol == 'o' || currentSymbol == 'u') {
                    countVowels++;
                }
                else if (currentSymbol == '!' || currentSymbol == ',' || currentSymbol == '.' || currentSymbol == '?') {
                    countPunctuations++;
                }
                else {
                    countConsonants++;
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Windows\\IdeaProjects" +
                "\\untitled\\src\\FilesAndStreamsEx\\output4.txt"));

        writer.write("Vowels: " + countVowels);
        writer.newLine();
        writer.write("Other symbols: " + countConsonants);
        writer.newLine();
        writer.write("Punctuation: " + countPunctuations);

        writer.close();
    }
}
