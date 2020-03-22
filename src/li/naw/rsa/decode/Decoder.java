package li.naw.rsa.decode;

import li.naw.rsa.model.RSAPrivateKey;
import li.naw.rsa.utils.FastExponentiation;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * decodes an encoded string with the help of a private key
 */
public class Decoder {
    private final RSAPrivateKey privateKey;

    public Decoder(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * decode string
     */
    public String decode(String toDecode) {
        return Arrays.stream(toDecode.split(","))
                .map(this::decodePart)
                .collect(Collectors.joining());
    }

    /**
     * helper to decode a character
     */
    private String decodePart(String part) {
        return String.valueOf((char)
                        new FastExponentiation(new BigInteger(part),
                                privateKey.getD(),
                                privateKey.getN())
                                .calculateMod()
                                .intValueExact()
        );
    }
}
