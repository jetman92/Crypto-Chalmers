import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.regex.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file= new File("inputFiles/testread.txt");
		
		try{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			
			try {
				String linep = buff.readLine();
				String lineq = buff.readLine();
				String lineg = buff.readLine();
				BigInteger p;
				BigInteger q;
				BigInteger g;
				try{
					if (linep.matches("p=\\d+")){
						p = new BigInteger(linep.split("=")[1]);
					}
					if (lineq.matches("q=\\d+")||!lineg.matches("g=\\d+")){
						q = new BigInteger(lineq.split("=")[1]);
					}
					if(lineg.matches("g=\\d+")){
						g = new BigInteger(lineg.split("=")[1]);
					}	
				}
				catch(Exception e){
					System.out.println("invalid_group");
				}
			
							
			}
			finally {
			buff.close();
			}
			} 
		catch (IOException ioe) {
			// erreur de fermeture des flux
			System.out.println("Erreur --" + ioe.toString());
			}
		
		
		
		
		
	}
	
	

}
