package Advanced.StreamsFilesAndDirectories.Ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SumLines01 {
    public static void main(String[] args) throws IOException {
        String pathStr = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\input.txt";
        Path path = Paths.get(pathStr);
        List<String> allLines = Files.readAllLines(path);

        allLines.stream().map(String::toCharArray).forEach(
                charArray -> {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                }
        );

    }
}
