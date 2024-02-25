import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayToOutputStreamExample {
    public static void main(String[] args) {
        // Sample byte array content
        byte[] content = "This is Java Practical number 5!".getBytes();

        // Create a ByteArrayInputStream from the byte array
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content);

        // Define the file name and path
        String fileName = "output.txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            // Read from the ByteArrayInputStream and write to the FileOutputStream
            int data;
            while ((data = byteArrayInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
            System.out.println("Content successfully written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the ByteArrayInputStream
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                System.out.println("An error occurred while closing the ByteArrayInputStream: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
