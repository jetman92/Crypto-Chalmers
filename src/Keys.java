import java.math.BigInteger;
import java.security.SecureRandom;

public class Keys {
	
	private BigInteger privateKey;
	private BigInteger publicKey;
	
	
	public Keys(DSACommunity com) {
		BigInteger q = com.getQ();
		SecureRandom priv = new SecureRandom();
		
		
	}
	
	

}
