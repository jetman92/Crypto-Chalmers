import java.math.BigInteger;


public class Verify {
	
	BigInteger u1, u2, v, w, z;
	
	
	public Verify(DSACommunity com, BigInteger r, BigInteger s, String digest, Keys key){
		if((r.compareTo(com.getQ()) == 1) ||(r.compareTo(new BigInteger("0")) == -1) || (s.compareTo(com.getQ()) == 1)|| (r.compareTo(new BigInteger("0")) == -1)){
			System.out.println("Signature invalid");
			//return 0;
		}
		
		w = (s.modInverse(com.getQ())).mod(com.getQ());
		int digestLenght = digest.getBytes().length * 4;
		int qLength = com.getQ().bitLength();
		
		int min;
		if(digestLenght > qLength){
			min = qLength;
		}
		else{
			min = digestLenght;
		}
		
		byte[] array = digest.getBytes();
		StringBuilder binary = new StringBuilder();
		  for (byte b : array)
		  {
		     int val = b;
		     for (int i = 0; i < 8; i++)
		     {
		        binary.append((val & 128) == 0 ? 0 : 1);
		        val <<= 1;
		     }		     
		  }
		  StringBuilder build = new StringBuilder();
		  for(int i=0; i<min; i++){
			  build.append(binary.charAt(i));
		  }
		  
		  z = new BigInteger(build.toString(), 2);
		  
		  u1 = (z.multiply(w)).mod(com.getQ());
		  
		  u2 = (r.multiply(w)).mod(com.getQ());
		  
		  v = (com.getG().modPow(u1, com.getQ()).multiply(key.getPublicKey().modPow(u2, com.getQ()))).mod(com.getQ());
		  
		  if(v.compareTo(r) == 0){
			  System.out.println("Signature valid");
			 // return 1;
		  }
		  
		  System.out.println("Signature invalid");
		
		//return 0;
	}

}
