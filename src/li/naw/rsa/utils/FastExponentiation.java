package li.naw.rsa.utils;

import java.math.BigInteger;

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
        final String binaryString = exponent.toString(2);
        int i = binaryString.length() - 1;
        BigInteger h = BigInteger.ONE;
        BigInteger k = base;

        while (i >= 0) {
            if (binaryString.charAt(i) == '1') {
                h = k.multiply(h).mod(mod);
            }

            k = k.sqrt().mod(mod);
            i = i - 1;
        }

        return h;
    }
}
