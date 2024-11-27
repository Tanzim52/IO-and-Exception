import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class URLContentDownloader {
    public static void main(String[] args) {
        String urlFile = "urls.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(urlFile))) {
            String urlString;
            int count = 1;

            while ((urlString = reader.readLine()) != null) {
                try {
                    URL url = new URL(urlString);
                    try (BufferedReader urlReader = new BufferedReader(new InputStreamReader(url.openStream()));
                         BufferedWriter writer = new BufferedWriter(new FileWriter("content_" + count + ".txt"))) {

                        String line;
                        while ((line = urlReader.readLine()) != null) {
                            writer.write(line);
                            writer.newLine();
                        }
                        System.out.println("Downloaded content from: " + urlString);
                        count++;
                    }
                } catch (Exception e) {
                    System.err.println("Error downloading content from: " + urlString + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading URL file: " + e.getMessage());
        }
    }
}
