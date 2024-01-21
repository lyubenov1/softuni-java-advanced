package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab");

        File root = path.toFile();

        Deque<File> queue = new ArrayDeque<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            File file = queue.poll();
            System.out.println(file.getName());
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    } else {
                        System.out.println(f.getName());
                    }
                }
            }
        }
    }
}
