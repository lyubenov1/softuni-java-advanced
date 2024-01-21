package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

    Path path = Paths.get("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\input.txt");

        List<String> lines = Files.readAllLines(path)
                .stream()
                .sorted()
                .toList();

        BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\Windows\\IdeaProjects" +
                "\\untitled\\src\\FilesAndStreamsLab" +
                "\\out-sort-lines.txt"));

        writer.write(lines.stream()
                .collect(Collectors
                        .joining(System.lineSeparator())));
        writer.close();

    }
}
