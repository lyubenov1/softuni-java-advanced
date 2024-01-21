package Advanced.StreamsFilesAndDirectories.Ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path pathFileOne = Path.of("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\inputOne.txt");
        List<String> allLinesFirstFile = Files.readAllLines(pathFileOne);

        Path pathFileTwo = Path.of("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\inputTwo.txt");
        List<String> allLinesSecondFile = Files.readAllLines(pathFileTwo);

        PrintWriter writer = new PrintWriter("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\outputMerge.txt");
        allLinesFirstFile.forEach(writer::println);
        allLinesSecondFile.forEach(line -> writer.println(line));

        writer.close();
    }
}
