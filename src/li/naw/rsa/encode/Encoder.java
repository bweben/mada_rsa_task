package li.naw.rsa.encode;

import li.naw.rsa.model.RSAPublicKey;
import li.naw.rsa.utils.FastExponentiation;

import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 * encodes a string with the help of a public key
 */
public class Encoder {
    private final RSAPublicKey publicKey;

    public Encoder(RSAPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * encode string
     */
    public String encode(String toEncode) {
        return toEncode.chars()
                .mapToObj(this::encode)
                .collect(Collectors.joining(","));
    }

    /**
     * helper to encode a character
     */
    private String encode(int asciiCode) {
        return new FastExponentiation(BigInteger.valueOf(asciiCode),
                publicKey.getE(),
                publicKey.getN())
                .calculateMod()
                .toString(10);
    }
}
