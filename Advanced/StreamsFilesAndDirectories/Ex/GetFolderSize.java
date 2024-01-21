package Advanced.StreamsFilesAndDirectories.Ex;

import java.io.File;

public class GetFolderSize {

    public static long getFolderSize(File folder) {
        long size = 0;

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        size += file.length();
                    } else {
                        size += getFolderSize(file);
                    }
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        String pathStr = "C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsEx\\Exercises Resources";

        File folder = new File(pathStr);

        if (folder.exists() && folder.isDirectory()) {
            long sizeInBytes = getFolderSize(folder);
            System.out.println("Folder size: " + sizeInBytes);
        }

    }
}