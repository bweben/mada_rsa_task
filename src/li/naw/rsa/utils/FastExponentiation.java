package li.naw.rsa.utils;

import java.math.BigInteger;

public class FastExponentiation {
    private final BigInteger base;
    private final int exponent;
    private final BigInteger mod;

    public FastExponentiation(BigInteger base, int exponent, BigInteger mod) {
        this.base = base;
        this.exponent = exponent;
        this.mod = mod;
    }

    public BigInteger calculateMod() {
        final String binaryString = Integer.toBinaryString(exponent);
        int i = binaryString.length() - 1;
        BigInteger h = BigInteger.ONE;
        BigInteger k = base;

        while (i >= 0) {
            if (binaryString.charAt(i) == '1') {
                h = k.multiply(BigInteger.valueOf(i)).mod(mod);
            }

            k = k.sqrt().mod(mod);
            i = i - 1;
        }

        return h;
    }
}
