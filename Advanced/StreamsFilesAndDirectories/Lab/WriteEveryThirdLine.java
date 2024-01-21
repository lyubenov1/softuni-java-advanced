package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String filePath = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\input.txt";

        FileInputStream inputStream = new FileInputStream(filePath);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader);

        BufferedWriter writer = new BufferedWriter(new PrintWriter("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\out-third-line.txt"));

        String line = reader.readLine();


        int count = 1;
        while (line != null) {
            if (count % 3 == 0) {
                writer.write(line + System.lineSeparator());
            }
            line = reader.readLine();
            count++;

        }

        writer.flush();
        // writer.close();
    }
}
