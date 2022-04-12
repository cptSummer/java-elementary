package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class LoggerFile {
    File logFilePath = new File("log");
    File logFile = new File(logFilePath + "\\result.log");

    public LoggerFile() throws URISyntaxException {

    }

    public void createLoggerFolder() {
        logFilePath.mkdir();
    }

    public void info(File file, File newFile) throws URISyntaxException, IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(logFile, true));
        printWriter.println("-----" + LocalTime.now() + "-----");
        printWriter.println("Name: " + file.getName() + "-->" + newFile.getName());
        printWriter.println("Size: " + Files.size(file.toPath()) + "-->" + Files.size(newFile.toPath()));
        printWriter.close();
    }

    public void info(String info) throws IOException, URISyntaxException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(logFile, true));
        printWriter.println("-----" + LocalDate.now() + " " + LocalTime.now() + "-----");
        printWriter.println(info);
        printWriter.close();
    }

    public void info(Double info) throws IOException, URISyntaxException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(logFile, true));
        printWriter.println("-----" + LocalDate.now() + " " + LocalTime.now() + "-----");
        printWriter.println(info);
        printWriter.close();
    }
}
