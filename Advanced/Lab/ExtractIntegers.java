package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);

    String filePath = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\input.txt";

    FileInputStream inputStream = new FileInputStream(filePath);

    FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\out-numbers.txt");

    PrintStream out = new PrintStream(String.valueOf(inputStream));


    while (scan.hasNext()) {
        if (scan.hasNextInt()) {
            int number = scan.nextInt();
            out.println(number);
        }
        scan.next();

    }
    inputStream.close();
    outputStream.close();
}
}
