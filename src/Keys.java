import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Keys {
	
	private BigInteger privateKey;
	private BigInteger publicKey;
	
	
	public Keys(DSACommunity com) {
		BigInteger q = com.getQ();
		SecureRandom random = null;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] privkey = new byte[20];
		privateKey = q;
		while( (q.compareTo(privateKey) == -1) || (q.compareTo(privateKey) == 0) || (privateKey.compareTo(new BigInteger("0")) == 0)){
			random.nextBytes(privkey);
			privateKey = new BigInteger(privkey).abs();
		}
		
		BigInteger g = com.getG();
		BigInteger p = com.getP();
		
		publicKey = g.modPow(privateKey, p);
		
		System.out.println(privateKey.toString());
		System.out.println(publicKey.toString());
		
		
	}


	public BigInteger getPrivateKey() {
		return privateKey;
	}


	public BigInteger getPublicKey() {
		return publicKey;
	}
	
	

}
