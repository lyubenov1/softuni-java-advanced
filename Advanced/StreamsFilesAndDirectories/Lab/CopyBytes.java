package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);

    String filePath = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\input.txt";

    FileInputStream inputStream = new FileInputStream(filePath);

    FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\out-as-bytes.txt");

    PrintStream out = new PrintStream(outputStream);

    int value = inputStream.read();

    while (value != -1) {
        if (value != 10 && value != 32) {
            out.print(value);
        } else {
            out.print((char) value);
        }
        value = inputStream.read();
    }
    inputStream.close();
    outputStream.close();
}
}
