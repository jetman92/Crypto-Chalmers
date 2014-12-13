import java.math.BigInteger;


public class DSAGen {
	
	private String DSA;
	private BigInteger r;
	private BigInteger z;
	private BigInteger s;
	
	public DSAGen(DSACommunity com){
		MessageSecretKey mKey = new MessageSecretKey(com);
		
		BigInteger k = mKey.getSecretKey();
		r = (com.getG().modPow(k, com.getP())).mod(com.getQ());
		
		
	}

}
