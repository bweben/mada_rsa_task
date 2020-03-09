package li.naw.rsa.utils;

import li.naw.rsa.model.RSAPrivateKey;

import java.io.IOException;
import java.math.BigInteger;

public class FileToPrivateKey {
    private final String file;

    public FileToPrivateKey(String file) {
        this.file = file;
    }

    public RSAPrivateKey loadPrivateKey() {
        try {
            final String privateKeyAsString = new FileReader().readAsString(file);
            final String[] nAndD = privateKeyAsString.split("\n");

            return new RSAPrivateKey(new BigInteger(nAndD[0]), new BigInteger(nAndD[1]));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
