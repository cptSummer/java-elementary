package main;

import sevise.ConvertToJSON;
import sevise.ConvertToYAML;
import utils.FileFilter;
import utils.FileUtils;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws URISyntaxException {
        FileUtils fileUtils = new FileUtils();
        String path = fileUtils.searchFolder();



    }



    private static void createLoggerFolder() {
        File logFilePath = new File("log");
        logFilePath.mkdir();
        File logFile = new File(logFilePath + "\\result.log");

    }




}
