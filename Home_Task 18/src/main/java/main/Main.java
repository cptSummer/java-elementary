package main;

import utils.FileUtils;

import java.io.File;
import java.net.URISyntaxException;


public class Main {

    public static void main(String[] args) throws URISyntaxException {
        FileUtils fileUtils = new FileUtils();
        String path;
        if(args.length != 0){
            path = args[0];
        }else {
            path = checkDirectory();
        }
        fileUtils.startConversionFiles(path);

    }



    private static void createLoggerFolder() {
        File logFilePath = new File("log");
        logFilePath.mkdir();
        File logFile = new File(logFilePath + "\\result.log");

    }
    private static String checkDirectory() throws URISyntaxException {
        return new File((Main.class
                .getProtectionDomain()
                .getCodeSource().getLocation()
                .toURI()).getPath()).getParent();

    }




}
