package li.naw.rsa.utils;

import li.naw.rsa.model.RSAPublicKey;

import java.io.IOException;
import java.math.BigInteger;

public class FileToPublicKey {
    private final String file;

    public FileToPublicKey(String file) {
        this.file = file;
    }

    public RSAPublicKey loadPublicKey() {
        try {
            final String publicKeyAsString = new FileReader().readAsString(file);
            final String[] nAndE = publicKeyAsString.split("\n");

            return new RSAPublicKey(new BigInteger(nAndE[0]), new BigInteger(nAndE[1]));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
