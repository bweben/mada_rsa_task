package li.naw.rsa.encode;

import li.naw.rsa.model.RSAPublicKey;
import li.naw.rsa.utils.FastExponentiation;

import java.math.BigInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Encoder {
    private final RSAPublicKey publicKey;

    public Encoder(RSAPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public String encode(String toEncode) {
        return toEncode.chars()
                .mapToObj(this::encode)
                .collect(Collectors.joining(","));
    }

    private String encode(int asciiCode) {
        return new FastExponentiation(BigInteger.valueOf(asciiCode),
                publicKey.getE().intValueExact(),
                publicKey.getN())
                .calculateMod()
                .toString(10);
    }
}
