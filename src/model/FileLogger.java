package model;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends FIleCreatorTxt implements LogInFile {

    private String logInformation;

    public void setLogInformation(String logInformation) {
        this.logInformation = logInformation;
    }
    public String getLogInformation() {
        return logInformation;
    }
    protected FileWriter fileWriter;

    @Override
    public void log() {
        if (fileLogger.exists()) {
            try {
                this.fileWriter = new FileWriter(fileLogger.getName(), true);

                fileWriter.write(getLogInformation());
                fileWriter.append('\n');
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else System.err.println("file not exists");
    }
}