package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String filePath = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\input.txt";

        Path path = Paths.get(filePath);

        FileInputStream inputStream = new FileInputStream(String.valueOf(path));

        int value = inputStream.read();

        while (value != -1) {
            System.out.printf(Integer.toBinaryString(value) + " ");
            value = inputStream.read();
        }
    }
}
