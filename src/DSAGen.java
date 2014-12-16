import java.math.BigInteger;


public class DSAGen {
	
	private String DSA;
	private BigInteger r = new BigInteger("0");
	private BigInteger z;
	private BigInteger s =  new BigInteger("0");
	
	public DSAGen(DSACommunity com, Keys key,String digest){
		MessageSecretKey mKey = new MessageSecretKey(com);
		
		while(r.compareTo(new BigInteger("0")) == 0 && s.compareTo(new BigInteger("0")) == 0  ){
		BigInteger k = mKey.getSecretKey();
		r = (com.getG().modPow(k, com.getP())).mod(com.getQ());
		
		
		  z = new BigInteger(digest, 16);		  
		  //use of modInverse with gives the inverse of k modulo Q
		  //(k^(-1) * (z + x*r)) mod q
		  s = (k.modInverse(com.getQ())).multiply((z.add(r.multiply(key.getPrivateKey())))).mod(com.getQ());
		  
		}
		
				
		
	}

	public BigInteger getR() {
		return r;
	}

	public BigInteger getS() {
		return s;
	}

}
