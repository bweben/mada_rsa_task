package li.naw.rsa.decode;

import li.naw.rsa.model.RSAPrivateKey;
import li.naw.rsa.utils.FastExponentiation;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Decoder {
    private final RSAPrivateKey privateKey;

    public Decoder(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String decode(String toDecode) {
        return Arrays.stream(toDecode.split(","))
                .map(this::encode)
                .collect(Collectors.joining());
    }

    private String encode(String part) {
        return String.valueOf(
                Character.highSurrogate(
                        new FastExponentiation(new BigInteger(part),
                                privateKey.getD().intValueExact(),
                                privateKey.getN())
                                .calculateMod()
                                .intValueExact()
                )
        );
    }
}
