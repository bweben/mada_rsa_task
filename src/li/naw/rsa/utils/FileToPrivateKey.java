package li.naw.rsa.utils;

import li.naw.rsa.model.RSAPrivateKey;

import java.io.IOException;
import java.math.BigInteger;

/**
 * convert a file path to a private key
 */
public class FileToPrivateKey {
    private final String file;

    public FileToPrivateKey(String file) {
        this.file = file;
    }

    public RSAPrivateKey loadPrivateKey() {
        try {
            final String privateKeyAsString = new FileReader().readAsString(file);
            final String[] nAndD = privateKeyAsString.split(",");

            return new RSAPrivateKey(new BigInteger(nAndD[0].substring(1)),
                    new BigInteger(nAndD[1].substring(0, nAndD[1].length() - 1)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
