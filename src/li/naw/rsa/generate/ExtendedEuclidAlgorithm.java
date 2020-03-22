package li.naw.rsa.generate;

import li.naw.rsa.model.EuclidResult;

import java.math.BigInteger;

public class ExtendedEuclidAlgorithm {
    public EuclidResult calculate(BigInteger a, BigInteger b) {
        BigInteger x0 = BigInteger.ONE;
        BigInteger x1 = BigInteger.ZERO;

        BigInteger y0 = BigInteger.ZERO;
        BigInteger y1 = BigInteger.ONE;

        while (!b.equals(BigInteger.ZERO)) {
            BigInteger[] divideAndRemainder = a.divideAndRemainder(b);

            BigInteger q = divideAndRemainder[0];
            BigInteger r = divideAndRemainder[1];

            a = b;
            b = r;

            BigInteger x0Copy = x0;
            BigInteger y0Copy = y0;

            x0 = x1;
            y0 = y1;
            x1 = x0Copy.subtract(q.multiply(x1));
            y1 = y0Copy.subtract(q.multiply(y1));
        }

        return new EuclidResult(a, b, x0, y0);
    }
}
