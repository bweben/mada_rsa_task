package li.naw.rsa.model;

import java.math.BigInteger;

/**
 * stores the result of the euclid algorithm
 */
public class EuclidResult {
    private BigInteger a;
    private BigInteger b;
    private BigInteger x0;
    private BigInteger y0;

    public EuclidResult(BigInteger a, BigInteger b, BigInteger x0, BigInteger y0) {
        this.a = a;
        this.b = b;
        this.x0 = x0;
        this.y0 = y0;
    }

    public BigInteger getA() {
        return a;
    }

    public void setA(BigInteger a) {
        this.a = a;
    }

    public BigInteger getB() {
        return b;
    }

    public void setB(BigInteger b) {
        this.b = b;
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
