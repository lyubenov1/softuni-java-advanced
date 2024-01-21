package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String filePath = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\input.txt";

        Path path = Paths.get(filePath);

        FileInputStream inputStream = new FileInputStream(String.valueOf(path));

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\out.txt");

        int value = inputStream.read();

        Set<Character> set = Set.of(',', '.', '!', '?');

        while (value != -1) {
            char current = (char) value;
            if (!set.contains(current)) {
                outputStream.write(current);
            }
            value = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
