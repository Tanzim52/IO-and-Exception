import java.io.*;
import java.nio.file.*;

public class WordReplacer {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String targetWord = "oldWord";
        String replacementWord = "newWord";

        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            content = content.replace(targetWord, replacementWord);
            Files.write(Paths.get(fileName), content.getBytes());
            System.out.println("Word replaced successfully.");
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
