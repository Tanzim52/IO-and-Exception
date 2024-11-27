import java.io.*;
import java.util.regex.*;

public class EmailValidator {
    public static void main(String[] args) {
        String inputFile = "emails.txt";
        String outputFile = "valid_emails.txt";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String email;
            while ((email = reader.readLine()) != null) {
                if (pattern.matcher(email).matches()) {
                    writer.write(email);
                    writer.newLine();
                }
            }
            System.out.println("Valid emails written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error processing email file: " + e.getMessage());
        }
    }
}
