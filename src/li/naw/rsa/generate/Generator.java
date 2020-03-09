package li.naw.rsa.generate;

import li.naw.rsa.model.RSAKeys;
import li.naw.rsa.model.RSAPrivateKey;
import li.naw.rsa.model.RSAPublicKey;

import java.math.BigInteger;
import java.util.Random;

public class Generator {
    private static final int RSA_LENGTH = 1024;

    public RSAKeys generateRSAKeys() {
        BigInteger p = BigInteger.probablePrime(RSA_LENGTH, new Random());
        BigInteger q = p;

        while (p.equals(q)) { // eliminate minimal change that the probablePrime function returns two times the same result
            q = BigInteger.probablePrime(RSA_LENGTH, new Random());
        }

        BigInteger n = p.multiply(q);
        BigInteger m = generatePhi(n);

        BigInteger e = genreateE(m);
        BigInteger d = new ExtendedEuclidAlgorithm().calculate(m, e).getY0();

        return new RSAKeys(new RSAPrivateKey(n, d), new RSAPublicKey(n, e));
    }

    private BigInteger genreateE(BigInteger m) {
        return BigInteger.ONE;
    }

    private BigInteger generatePhi(BigInteger n) {
        return BigInteger.ONE;
    }
}
