package li.naw.rsa.model;

import java.math.BigInteger;

public class RSAPrivateKey implements RSAKey {
    private static final String file = "sk.txt";

    private BigInteger n;
    private BigInteger d;

    public RSAPrivateKey(BigInteger n, BigInteger d) {
        this.n = n;
        this.d = d;
    }

    public String getFile() {
        return file;
    }

    public String getContent() {
        return getN() + "\n" + getD();
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }
}
