package Advanced.StreamsFilesAndDirectories.Ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes02 {
    public static void main(String[] args) throws IOException {
        String pathStr = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\input.txt";
        byte[] allBytes = Files.readAllBytes(Path.of(pathStr));
        long sum = 0;
        for (byte value : allBytes) {
            if (value != 10 && value!= 13) {
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
