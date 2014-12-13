import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class MessageSecretKey {
	
	private BigInteger secretKey;
	
	public MessageSecretKey(DSACommunity com){
		BigInteger q = com.getQ();
		SecureRandom random = null;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] key = new byte[20];
		secretKey = q;
		while( ((q.compareTo(secretKey) == -1) || (q.compareTo(secretKey) == 0))){
			random.nextBytes(key);
			secretKey = new BigInteger(key).abs();
		}
		
		
	}

	public BigInteger getSecretKey() {
		return secretKey;
	}
	
	
}
