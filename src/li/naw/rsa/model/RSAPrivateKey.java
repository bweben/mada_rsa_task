package li.naw.rsa.model;

import java.math.BigInteger;

/**
 * wrapper to store the RSA private key
 */
public class RSAPrivateKey implements RSAKey {
    private static final String FILE = "sk.txt";

    private BigInteger n;
    private BigInteger d;

    public RSAPrivateKey(BigInteger n, BigInteger d) {
        this.n = n;
        this.d = d;
    }

    public String getFile() {
        return FILE;
    }

    public String getContent() {
        return "(" + getN() + "," + getD() + ")";
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
