package li.naw.rsa.utils;

import li.naw.rsa.model.RSAKey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {
    private final RSAKey key;

    public FileWriter(RSAKey key) {
        this.key = key;
    }

    public void writeToFile() throws IOException {
        Files.writeString(Path.of(key.getFile()), key.getContent());
    }
}
