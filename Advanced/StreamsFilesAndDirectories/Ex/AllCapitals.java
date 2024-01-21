package Advanced.StreamsFilesAndDirectories.Ex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String pathStr = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Windows\\IdeaProjects" +
                "\\untitled\\src\\FilesAndStreamsEx\\output3.txt"));

        Files.readAllLines(Path.of(pathStr)).forEach(
                line -> {
                    try {
                        writer.write(line.toUpperCase());
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        writer.write("");
        writer.newLine();
        writer.close();


    }
}
