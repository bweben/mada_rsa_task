package li.naw.rsa.generate;

import javafx.util.Pair;
import li.naw.rsa.model.EuclidResult;
import li.naw.rsa.model.RSAKeys;
import li.naw.rsa.model.RSAPrivateKey;
import li.naw.rsa.model.RSAPublicKey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * generator to generate a RSA private / public key pair
 */
public class Generator {
    /**
     * length of the RSA keys
     */
    private static final int RSA_LENGTH = 2048;

    /**
     * create instance of a SecureRandom
     */
    private static final Random RANDOM = new SecureRandom();

    /**
     * generate the private and public key
     */
    public RSAKeys generateRSAKeys() {
        BigInteger p = BigInteger.probablePrime(RSA_LENGTH, RANDOM);
        BigInteger q = p;

        while (p.equals(q)) { // eliminate minimal change that the probablePrime function returns two times the same result
            q = BigInteger.probablePrime(RSA_LENGTH, RANDOM);
        }

        BigInteger n = p.multiply(q);
        BigInteger m = generatePhi(p, q);

        Pair<BigInteger, BigInteger> eAndDPair = genreateEAndD(m);
        BigInteger e = eAndDPair.getKey();
        BigInteger d = eAndDPair.getValue();

        return new RSAKeys(new RSAPrivateKey(n, d), new RSAPublicKey(n, e));
    }

    /**
     * calculate e which is used by the public key as well as d which is used by the private key
     */
    private Pair<BigInteger, BigInteger> genreateEAndD(BigInteger m) {
        ExtendedEuclidAlgorithm euclidAlgorithm = new ExtendedEuclidAlgorithm();
        EuclidResult result;
        BigInteger e;

        do {
            e = new BigInteger(RSA_LENGTH / 2, RANDOM);
            result = euclidAlgorithm.calculate(m, e);
        } while (!result.getA().equals(BigInteger.ONE));

        return new Pair<>(e, result.getY0());
    }

    /**
     * generate result of phi function
     */
    private BigInteger generatePhi(BigInteger p, BigInteger q) {
        // (p-1)*(p^e1-1) * (q-1)*(q^e2-1) = (p-1)*(q-1) because e1-1 and e2-1 equals 0 and x^0 equals 1
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }
}
