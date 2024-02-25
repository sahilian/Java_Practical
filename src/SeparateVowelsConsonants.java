import java.io.*;

public class SeparateVowelsConsonants {
    public static void main(String[] args) {
        // Specify the input file path
        String inputFilePath = "input.txt";

        // Specify the output file paths for vowels and consonants
        String vowelsOutputFilePath = "vowels.txt";
        String consonantsOutputFilePath = "consonants.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter vowelsWriter = new BufferedWriter(new FileWriter(vowelsOutputFilePath));
             BufferedWriter consonantsWriter = new BufferedWriter(new FileWriter(consonantsOutputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        if (isVowel(c)) {
                            vowelsWriter.write(c);
                        } else {
                            consonantsWriter.write(c);
                        }
                    }
                }
            }

            System.out.println("Separation of vowels and consonants completed.");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
