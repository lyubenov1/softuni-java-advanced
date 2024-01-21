package Advanced.StreamsFilesAndDirectories.Ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String pathStr = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\InputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathStr));

        PrintWriter writer = new PrintWriter("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\output-lineNumbers.txt");

        int countRow = 1;
        for (String line : allLines) {
            writer.println(countRow + ". " + line);
            countRow++;
        }
        writer.close();
    }
}
