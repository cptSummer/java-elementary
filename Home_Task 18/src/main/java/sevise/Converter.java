package sevise;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public interface Converter {

    void convert(Path path) throws URISyntaxException, IOException;
    String createFileName(Path path);
}
