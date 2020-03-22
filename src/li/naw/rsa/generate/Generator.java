package li.naw.rsa.generate;

import li.naw.rsa.model.RSAKeys;
import li.naw.rsa.model.RSAPrivateKey;
import li.naw.rsa.model.RSAPublicKey;

import java.math.BigInteger;
import java.util.Random;

public class Generator {
    private static final int RSA_LENGTH = 2048;

    public RSAKeys generateRSAKeys() {
        BigInteger p = BigInteger.probablePrime(RSA_LENGTH, new Random());
        BigInteger q = p;

        while (p.equals(q)) { // eliminate minimal change that the probablePrime function returns two times the same result
            q = BigInteger.probablePrime(RSA_LENGTH, new Random());
        }

        BigInteger n = p.multiply(q);
        BigInteger m = generatePhi(p, q);

        BigInteger e = genreateE(m);
        BigInteger d = new ExtendedEuclidAlgorithm().calculate(m, e).getY0();

        return new RSAKeys(new RSAPrivateKey(n, d), new RSAPublicKey(n, e));
    }

    private BigInteger genreateE(BigInteger m) {
        BigInteger e = BigInteger.ZERO;
        while (!e.equals(BigInteger.ZERO) || !e.mod(m).equals(BigInteger.ONE)) {
            e = BigInteger.probablePrime(RSA_LENGTH / 2, new Random());
        }

        return BigInteger.ONE;
    }

    private BigInteger generatePhi(BigInteger p, BigInteger q) {
        // (p-1)*(p^e1-1) * (q-1)*(q^e2-1) = (p-1)*(q-1) because e1-1 and e2-1 equals 0 and x^0 equals 1
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }
}
