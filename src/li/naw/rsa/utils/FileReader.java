package li.naw.rsa.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public String readAsString(String file) throws IOException {
        return Files.readString(Path.of(file));
    }
}
