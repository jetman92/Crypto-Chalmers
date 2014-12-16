import java.math.BigInteger;


public class Verify {
	
	BigInteger u1, u2, v, w, z;
	
	
	public Verify(DSACommunity com, BigInteger r, BigInteger s, String digest, Keys key){
		//check that 0<r'< q and 0 < s' < q
		if((r.compareTo(com.getQ()) == 1) ||(r.compareTo(new BigInteger("0")) == -1) || (s.compareTo(com.getQ()) == 1)|| (r.compareTo(new BigInteger("0")) == -1)){
			System.out.println("Signature invald");
		}
		//calculate w
		w = (s.modInverse(com.getQ()));
		//calculate z with saying that digest is an hexadecimal string
		z = new BigInteger(digest, 16);
		
		u1 = (z.multiply(w)).mod(com.getQ());
		  
		u2 = (r.multiply(w)).mod(com.getQ());
		//ugly line but it works
		//use of modPow because (a * b)mod p = (a mod p * b mod p )mod p
		v = (((com.getG().modPow(u1, com.getP())).multiply(key.getPublicKey().modPow(u2, com.getP()))).mod(com.getP())).mod(com.getQ());
		  
		if(v.compareTo(r) == 0){
			  System.out.println("Signature valid");
			
		  }
		else{
		  
		  System.out.println("Signature invalid");
		  }
		
	}

}
