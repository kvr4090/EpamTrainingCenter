package by.epamtc.jwd.appliances_db.app;

import by.epamtc.jwd.appliances_db.appliances.Device;
import by.epamtc.jwd.appliances_db.catalogue.CatalogueAppliances;

import java.util.*;

public class Solution {

    private String nameDevice;
    private String deviceProperty;
    private String propertyValue;
    private List<Device> selectDevice;

    public Solution(String nameDevice, String deviceProperty, String propertyValue) {
        this.nameDevice = nameDevice;
        this.deviceProperty = deviceProperty;
        this.propertyValue = propertyValue;
        selectDevice = new ArrayList<>();
    }

    public List<Device> runApp() {
        CatalogueAppliances currentCatalogue = new CatalogueAppliances("\\F:\\appliances_db.txt");
        currentCatalogue.fillCatalogue();

        for (Device currentDevice : currentCatalogue.getCatalogue()) {

            if (currentDevice.getProperty().get("name").trim().equals(nameDevice)) {

                for (Map.Entry<String, String> current : currentDevice.getProperty().entrySet()) {

                    if (current.getKey().trim().equals(deviceProperty) && current.getValue().equals(propertyValue)) {

                        selectDevice.add(currentDevice);
                    }
                }
            }
        }

        return selectDevice;
    }
}
