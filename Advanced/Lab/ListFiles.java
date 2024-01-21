package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        // Provide the path to the folder
        String folderPath = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\Files-and-Streams";

        // Create a File object representing the folder
        File folder = new File(folderPath);

        // Check if the provided path is a directory
        if (folder.isDirectory()) {
            // Get the list of files in the directory
            File[] files = folder.listFiles();

            // Check if the array is not null (directory is not empty)
            if (files != null) {
                // Iterate through the array and print names and sizes
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName() + ": [" + file.length() + "]");
                    }
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}