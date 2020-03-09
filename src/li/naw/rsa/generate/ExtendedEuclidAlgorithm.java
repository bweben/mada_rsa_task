package li.naw.rsa.generate;

import li.naw.rsa.model.EuclidResult;

import java.math.BigInteger;

public class ExtendedEuclidAlgorithm {
    public EuclidResult calculate(BigInteger a, BigInteger b) {
        BigInteger x0 = BigInteger.ONE;
        BigInteger x1 = BigInteger.ZERO;

        BigInteger y0 = BigInteger.ZERO;
        BigInteger yy = BigInteger.ONE;

        while (b.compareTo(BigInteger.ZERO) != 0) {
        }

        return new EuclidResult(x0, y0);
    }
}
