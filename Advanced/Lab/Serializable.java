package Advanced.StreamsFilesAndDirectories.Lab;
import java.io.*;

class Cube implements Serializable {
    private String color;
    private double width;
    private double height;
    private double depth;

    // Constructor
    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Getters (and setters if needed)

    public String getColor() {
        return color;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public static void main(String[] args) {
        // Create a new instance of the Cube class and set its properties
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        // Serialize the object using ObjectOutputStream
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Windows\\IdeaProjects\\untitled\\src\\FilesAndStreamsLab\\cube.ser"))) {
            out.writeObject(cube);
            System.out.println("Cube object has been serialized and saved to cube.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
