import java.io.*;
import java.util.*;

public class ConfigHandler {
    public static void main(String[] args) {
        String configFile = "config.properties";
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(configFile)) {
            properties.load(fis);
            System.out.println("Current Configurations:");
            properties.forEach((key, value) -> System.out.println(key + ": " + value));

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the key to update: ");
            String key = scanner.nextLine();
            System.out.print("Enter the new value: ");
            String value = scanner.nextLine();

            properties.setProperty(key, value);

            try (FileOutputStream fos = new FileOutputStream(configFile)) {
                properties.store(fos, "Updated Configurations");
                System.out.println("Configurations updated successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error handling configuration file: " + e.getMessage());
        }
    }
}
