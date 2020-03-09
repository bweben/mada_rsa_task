package li.naw.rsa.model;

import java.math.BigInteger;

public class RSAPublicKey implements RSAKey {
    private static final String file = "pk.txt";

    private BigInteger n;
    private BigInteger e;

    public RSAPublicKey(BigInteger n, BigInteger e) {
        this.n = n;
        this.e = e;
    }

    public String getFile() {
        return file;
    }

    public String getContent() {
        return getN() + "\n" + getE();
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }
}
