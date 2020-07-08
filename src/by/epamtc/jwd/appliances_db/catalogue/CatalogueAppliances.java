package by.epamtc.jwd.appliances_db.catalogue;

import by.epamtc.jwd.appliances_db.appliances.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CatalogueAppliances {
    private List<Device> catalogue;
    private String filePath;

    public CatalogueAppliances(String filePath) {
        this.filePath = filePath;
    }

    public List<Device> getCatalogue() {
        return catalogue;
    }

    public void fillCatalogue() {

        try (FileReader fileReader = new FileReader(new File(filePath));
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();

            catalogue = new ArrayList<>();

            while (line != null) {
                catalogue.add(new Device(splitPropertiesDevice(line)));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Указанный файл не найден!");

        } catch (IOException q) {
            System.out.println(Arrays.toString(q.getStackTrace()));
        }
    }

    private String[] splitPropertiesDevice(String string) {
        Pattern pattern = Pattern.compile("[=:,]");
        return pattern.split(string);
    }
}
