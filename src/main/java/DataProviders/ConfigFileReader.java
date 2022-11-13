package DataProviders;


import Enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;

    public ConfigFileReader() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String propertyFilePath = "config/configuration.properties";

        try {
            fileReader = new FileReader(propertyFilePath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();

            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else
            throw new RuntimeException("url not specified in the config file.");
    }

    public String getInputFile() {
        String inPutFilePath = properties.getProperty("inPutFilePath");
        if (inPutFilePath != null) return inPutFilePath;
        else
            throw new RuntimeException("inPutFilePath not specified in the config file.");
    }

    public String getOutputFile() {
        String outPutFilePath = properties.getProperty("outPutFilePath");
        if (outPutFilePath != null) return outPutFilePath;
        else
            throw new RuntimeException("outPutFilePath not specified in the config file.");
    }


    public long getTime() {
        String timeout = properties.getProperty("timeout");
        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout not specified in the config file.");
        }
    }

    public String getRegistrationNoPattern() {
        String regNoPattern = properties.getProperty("regNoPattern");
        if (regNoPattern != null) return regNoPattern;
        else
            throw new RuntimeException("regNoPattern not specified in the config file.");
    }

    public DriverType getBrowser()  {
        String browserName = properties.getProperty("browser");

        switch (browserName) {
            case "chrome":
                return DriverType.CHROME;
            case "firefox":
                return DriverType.FIREFOX;
            case "safari":
                return DriverType.SAFARI;
            default:
                throw new RuntimeException("Browser name key value in configuration file is not matched: " + browserName);
        }
    }

}
