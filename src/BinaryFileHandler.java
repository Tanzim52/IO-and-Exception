import java.io.*;
import java.util.Scanner;

public class BinaryFileHandler {
    public static void main(String[] args) {
        String sourceFile = "source.dat";
        String targetFile = "target.dat";

        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error handling binary file: " + e.getMessage());
        }

        try (FileOutputStream appendStream = new FileOutputStream(targetFile, true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter data to append: ");
            String data = scanner.nextLine();
            appendStream.write(data.getBytes());
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
}
