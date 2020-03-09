package li.naw.rsa.model;

import java.math.BigInteger;

public class EuclidResult {
    private BigInteger x0;
    private BigInteger y0;

    public EuclidResult(BigInteger x0, BigInteger y0) {
        this.x0 = x0;
        this.y0 = y0;
    }

    public BigInteger getX0() {
        return x0;
    }

    public void setX0(BigInteger x0) {
        this.x0 = x0;
    }

    public BigInteger getY0() {
        return y0;
    }

    public void setY0(BigInteger y0) {
        this.y0 = y0;
    }
}
