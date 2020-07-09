package by.epamtc.jwd.appliances_db.appliances;

import java.util.HashMap;
import java.util.Map;

public class Device {

    private Map<String, String> properties;
    private String[] ArrayProperties;

    public Device(String[] propertiesLine) {
        this.ArrayProperties = propertiesLine;
        init();
    }

    private void init () {
        properties = new HashMap<>();
        properties.put("nameDevice", ArrayProperties[0]);

        for (int i = 1; i < ArrayProperties.length - 1; i += 2) {
            properties.put(ArrayProperties[i].trim(), ArrayProperties[i + 1].trim());
        }
    }

    public Map<String, String> getProperty() {
        return properties;
    }
}
