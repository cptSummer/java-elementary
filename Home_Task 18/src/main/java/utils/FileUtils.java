package utils;

import sevise.ConvertToJSON;
import sevise.ConvertToYAML;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileUtils {

    public void startConversionFiles(String path) throws URISyntaxException, IOException {
        LoggerFile log = new LoggerFile();
        Scanner sc = new Scanner(System.in);
        new LoggerFile().createLoggerFolder();
        ConvertToJSON convertJ = new ConvertToJSON();
        ConvertToYAML convertY = new ConvertToYAML();
        byte answer;

        System.out.println("Enter number of needed conversion");
        System.out.println("1-YAML to JSON, 2-JSON to YAML, 3-All files converted, 4-Exit");
        try {


            do {
                System.out.print(":: ");
                answer = sc.nextByte();
                if (answer == 1) {
                    File[] yamlList = findFiles(path, ".yaml");
                    for (File f : yamlList) {
                        long time = System.currentTimeMillis();
                        convertJ.convert(Path.of(path + File.separator + f.getName()));
                        log.info((double) ((System.currentTimeMillis() - time) / 1000));
                    }

                } else if (answer == 2) {
                    File[] jsonList = findFiles(path, ".json");
                    for (File f : jsonList) {
                        long time = System.currentTimeMillis();
                        convertY.convert(Path.of(path + File.separator + f.getName()));
                        log.info((double) ((System.currentTimeMillis() - time) / 1000));
                    }
                } else if (answer == 3) {
                    File[] jsonList = findFiles(path, ".json");
                    File[] yamlList = findFiles(path, ".yaml");
                    for (File f : yamlList) {
                        long time = System.currentTimeMillis();
                        convertJ.convert(Path.of(path + File.separator + f.getName()));
                        log.info((double) ((System.currentTimeMillis() - time) / 1000));
                    }
                    for (File f : jsonList) {
                        long time = System.currentTimeMillis();
                        convertY.convert(Path.of(path + File.separator + f.getName()));
                        log.info((double) ((System.currentTimeMillis() - time) / 1000));
                    }
                }
                System.out.println("Conversion complete");
            } while (answer != 4);
        } catch (NullPointerException e) {
            System.out.println("Folder doesn't have files with extension .json or .yaml");
            log.info("Folder doesn't have files with extension .json or .yaml");
        }
    }

    private static File[] findFiles(String dir, String ext) {
        File file = new File(dir);
        if (!file.exists()) System.out.println(dir + " folder doesn't exist");
        File[] listFiles = file.listFiles(new FileFilter(ext));
        if (listFiles.length == 0) {
            System.out.println(dir + " does not contain files with the extension " + ext);
        } else {
            return listFiles;
        }
        return null;
    }

}

