package app;

import java.io.*;

public class FileHandler {

    public String writeFile(String fileName, String fileContent) {
        try (
                Writer fw = new FileWriter(fileName + ".txt");
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write(fileContent);
            bw.flush();
            return "Success.";
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String readFile(String path) {
        try (
                Reader reader = new FileReader(path);
                BufferedReader br = new BufferedReader(reader)
        ) {
            int sym;
            StringBuilder stringBuilder = new StringBuilder();
            char[] buf = new char[1024];
            while ((sym = reader.read(buf)) != -1) {
                stringBuilder.append(buf, 0, sym);
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            return "Error: " + e.getMessage();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
