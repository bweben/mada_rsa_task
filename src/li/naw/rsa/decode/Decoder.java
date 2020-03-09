package li.naw.rsa.decode;

import li.naw.rsa.model.RSAPrivateKey;
import li.naw.rsa.utils.FastExponentiation;

import java.math.BigInteger;
import java.util.stream.Collectors;

public class Decoder {
    private final RSAPrivateKey privateKey;

    public Decoder(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String decode(String toDecode) {
        return toDecode.chars()
                .mapToObj(this::encode)
                .collect(Collectors.joining());
    }

    private String encode(int asciiCode) {
        return String.valueOf(
                Character.highSurrogate(
                        new FastExponentiation(BigInteger.valueOf(asciiCode),
                                privateKey.getD().intValueExact(),
                                privateKey.getN())
                                .calculateMod()
                )
        );
    }
}
