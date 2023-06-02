package Controller;

import Model.University;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonManager {
    private static final String FILE_PATH = "university.json";

    public static void writeUniversityToJson(University university) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static University readUniversityFromJson() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));
            String jsonString = new String(jsonData);
            Gson gson = new Gson();
            return gson.fromJson(jsonString, University.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
