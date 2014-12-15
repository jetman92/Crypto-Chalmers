import java.math.BigInteger;


public class DSAGen {
	
	private String DSA;
	private BigInteger r;
	private BigInteger z;
	private BigInteger s;
	
	public DSAGen(DSACommunity com, Keys key,String digest){
		MessageSecretKey mKey = new MessageSecretKey(com);
		
		while(r.compareTo(new BigInteger("0")) == 0 && s.compareTo(new BigInteger("0")) == 0  ){
		BigInteger k = mKey.getSecretKey();
		r = (com.getG().modPow(k, com.getP())).mod(com.getQ());
		
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
		  
		  z = new BigInteger(build.toString());
		  s = (new BigInteger("1").divide(k)).multiply((z.add(r.multiply(key.getPrivateKey())))).mod(com.getQ());
		  
		}
		
				
		
	}

	public BigInteger getR() {
		return r;
	}

	public BigInteger getS() {
		return s;
	}

}
