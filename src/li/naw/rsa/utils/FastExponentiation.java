package li.naw.rsa.utils;

import java.math.BigInteger;

/**
 * fast exponentiation algorithm implementation
 */
public class FastExponentiation {
    private final BigInteger base;
    private final BigInteger exponent;
    private final BigInteger mod;

    public FastExponentiation(BigInteger base, BigInteger exponent, BigInteger mod) {
        this.base = base;
        this.exponent = exponent;
        this.mod = mod;
    }

    public BigInteger calculateMod() {
        BigInteger h = BigInteger.ONE;
        BigInteger k = base;

        // convert BigInteger to binary to step through
        String exponentBinary = exponent.toString(2);
        int i = exponentBinary.length() - 1;

        while (i >= 0) {
            if (exponentBinary.charAt(i) == '1') {
                h = h.multiply(k).mod(mod);
            }

            k = k.modPow(BigInteger.TWO, mod);
            i = i - 1;
        }

        return h;
    }
}
