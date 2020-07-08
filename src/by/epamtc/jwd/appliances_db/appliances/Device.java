package by.epamtc.jwd.appliances_db.appliances;

import java.util.HashMap;
import java.util.Map;

public class Device {

    private Map<String, String> property;
    private String[] properties;

    public Device(String[] properties) {
        this.properties = properties;
        init();
    }

    private void init () {
        property = new HashMap<>();
        property.put("name", properties[0]);

        for (int i = 1; i < properties.length-1; i += 2) {
            property.put(properties[i], properties[i + 1]);
        }
    }

    public Map<String, String> getProperty() {
        return property;
    }
}
