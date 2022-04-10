package sevise;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.google.common.io.MoreFiles.*;
import org.slf4j.LoggerFactory;

@Slf4j
public class ConvertToJSON implements Converter {


    @Override
    public void convert(Path path) {
        try {
            String content = new String(Files.readAllBytes(path));
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Object obj = yamlReader.readValue(content, Object.class);
            ObjectMapper jsonWriter = new ObjectMapper(new JsonFactory());
            File newFile = new File(createFileName(path));
            jsonWriter.writeValue(newFile, obj);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String createFileName(Path path) {
        return path.getFileName().toString().replace(".yaml",".json");
    }
}
