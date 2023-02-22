package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileOperations {
    private Properties properties;
    public PropertyFileOperations(String filePath){
        File file = new File(filePath);
        properties= new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key){
        return properties.getProperty(key);
    }
}

