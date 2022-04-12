package sevise;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import utils.LoggerFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConvertToYAML implements Converter {

    @Override
    public String createFileName(Path path) {
        return path.getFileName().toString().replace(".json", ".yaml");
    }

    @Override
    public void convert(Path path) throws URISyntaxException, IOException {
        LoggerFile log = new LoggerFile();
        try {
            String content = new String(Files.readAllBytes(path));
            ObjectMapper jsonReader = new ObjectMapper(new JsonFactory());
            Object obj = jsonReader.readValue(content, Object.class);
            ObjectMapper yamlWriter = new ObjectMapper(new YAMLFactory());
            File filePath = new File("converted");
            filePath.mkdir();
            File oldFile = new File(String.valueOf(path));
            File newFile = new File(filePath + File.separator + createFileName(path));
            yamlWriter.writeValue(newFile, obj);
            log.info(oldFile, newFile);


        } catch (IOException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }


    }
}
