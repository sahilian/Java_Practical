import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            // Read each line from the input file and write it to the output file
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add newline character after each line
            }
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
