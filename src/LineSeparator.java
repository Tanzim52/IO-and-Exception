import java.io.*;

public class LineSeparator {
    public static void main(String[] args) {
        String inputFile = "largefile.txt";
        String evenFile = "evenlines.txt";
        String oddFile = "oddlines.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter evenWriter = new BufferedWriter(new FileWriter(evenFile));
             BufferedWriter oddWriter = new BufferedWriter(new FileWriter(oddFile))) {

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (lineNumber % 2 == 0) {
                    evenWriter.write(line);
                    evenWriter.newLine();
                } else {
                    oddWriter.write(line);
                    oddWriter.newLine();
                }
                lineNumber++;
            }

            System.out.println("Lines separated successfully.");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}
