import java.math.BigInteger;


public class DSACommunity {
	
	private BigInteger p;
	private BigInteger q;
	private BigInteger g;
	
	public DSACommunity(BigInteger p, BigInteger q, BigInteger g) {
		super();
		this.p = p;
		this.q = q;
		this.g = g;
	}

	boolean isPrime(BigInteger toTest){
		return toTest.isProbablePrime(1);
	}

	public BigInteger getP() {
		return p;
	}

	public void setP(BigInteger p) {
		this.p = p;
	}

	public BigInteger getQ() {
		return q;
	}

	public void setQ(BigInteger q) {
		this.q = q;
	}

	public BigInteger getG() {
		return g;
	}

	public void setG(BigInteger g) {
		this.g = g;
	}
	
	

}
