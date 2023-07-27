package model;

import view.CalculateView;

import java.io.File;
import java.io.IOException;

public class FIleCreatorTxt {
    protected CalculateView calculateView = new CalculateView();

    protected File fileLogger;

    public File getFileLogger() {
        return fileLogger;
    }
    public void createFile(String fileName) {
        try {
            this.fileLogger = new File(fileName);

            if (fileLogger.createNewFile()){
                System.out.println("file logger is created. \n" +
                        "file path: " + fileLogger.getAbsolutePath());
            }else System.out.println("the file already exists. \n" +
                    "file path: " + fileLogger.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
