package sevise;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.google.common.io.MoreFiles.*;
import org.slf4j.LoggerFactory;
import utils.LoggerFile;


public class ConvertToJSON implements Converter {

    @Override
    public void convert(Path path) throws URISyntaxException, IOException {
        LoggerFile log = new LoggerFile();
        try {
            String content = new String(Files.readAllBytes(path));
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Object obj = yamlReader.readValue(content, Object.class);
            ObjectMapper jsonWriter = new ObjectMapper(new JsonFactory());
            File filePath = new File("converted");
            filePath.mkdir();
            File oldFile = new File(String.valueOf(path));
            File newFile = new File(filePath + File.separator + createFileName(path));
            jsonWriter.writeValue(newFile, obj);
            log.info(oldFile, newFile);

        } catch (IOException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }

    @Override
    public String createFileName(Path path) {
        return path.getFileName().toString().replace(".yaml", ".json");
    }
}
