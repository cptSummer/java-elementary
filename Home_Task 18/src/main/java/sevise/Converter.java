package sevise;

import java.nio.file.Path;

public interface Converter {

    void convert(Path path);
    String createFileName(Path path);
}
