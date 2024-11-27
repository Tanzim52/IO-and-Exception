import java.io.*;
import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        String inputFile = "data.json";
        String outputFile = "data.xml";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            JSONObject json = new JSONObject(jsonContent.toString());
            String xmlContent = XML.toString(json);

            writer.write(xmlContent);
            System.out.println("JSON converted to XML successfully.");
        } catch (Exception e) {
            System.err.println("Error converting JSON to XML: " + e.getMessage());
        }
    }
}
