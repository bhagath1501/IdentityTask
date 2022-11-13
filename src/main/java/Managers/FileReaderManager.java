package Managers;

import DataProviders.ConfigFileReader;
import DataProviders.ReadDataFiles;

public class FileReaderManager {

    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static ReadDataFiles notepadReader;
    private FileReaderManager() {}

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public ReadDataFiles getDataFile() {
        return (notepadReader == null) ? new ReadDataFiles() : notepadReader;
    }
}
