import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.regex.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*BigInteger p = new BigInteger("102865584259843077175583195011997798900482038016705824136288380475734860009055428071534495956844807748416572686838253895244634687898659646424515259679129905513743899853971066468883670407530107234961085482225328667572772611162756643027105617873895021996158552984843708233824989792811721408577351617080369547993");
		BigInteger q = new BigInteger("734415599462729831694143846331445277609193755927");
		BigInteger g = new BigInteger("63615006880335642768473038477258757436464860136916565207798584167060621564899979263408565137993978149206751054438974059615983337126379668370747907507911540381031959187353048278562320341063050939775344313271013777131358834376209974551749493023310606751625276738876397935042130121966817767949476523717161640453");
		
		DSACommunity com = new DSACommunity(p, q, g);
		Keys key = new Keys(com);*/
		
		File file= new File("inputFiles/genkey");
		try{
			BufferedReader buff = new BufferedReader(new FileReader(file));		
			BigInteger p = null;
			BigInteger q = null;
			BigInteger g = null;
			int n = 0;
			String line;
			boolean tupleIsOk = true;
			try {			
				do { 
					line = buff.readLine();
					if (line.matches("[pqg]=\\d+"))
					{
						BigInteger pqg = new BigInteger(line.split("=")[1]);
						switch (line.split("=")[0]){
						case"p":{
							if (pqg.isProbablePrime(1)&&(pqg.bitLength()==1024)){
								p=pqg;
							}
							else {tupleIsOk=false;}
							break;
						}
						case"q":{
							if (pqg.isProbablePrime(1)&&(pqg.bitLength()==160)&&p!=null)
							{
								BigInteger pMinusOne=p.subtract(BigInteger.ONE);
								if(pMinusOne.mod(pqg)==BigInteger.ZERO)
								{
									q=pqg;
								}
								else{tupleIsOk=false;}
							}
							else{tupleIsOk=false;}
							break;
						}
						case"g":{
							if (pqg.compareTo(BigInteger.ONE)==1 && q!=null && pqg.modPow(q,p).compareTo(BigInteger.ONE)==0){
								g=pqg;
							}
							else{tupleIsOk=false;}
							break;
						}
						}
					}
					else {
						if(line.compareTo("genkey")!=0){
							System.out.println("invalid_fileformat");}}
				} while(tupleIsOk && line.compareTo("genkey")!=0);
				if (!tupleIsOk){
					System.out.println("invalid_group");
				}
				else{
					System.out.println("valid_group");
					DSACommunity DSA = new DSACommunity(p, q, g);
					line = buff.readLine();
					if (line.matches("n=\\d+")){
						n=Integer.parseInt(line.split("=")[1]);
						for (int i=0; i<n;i++){
							Keys keys = new Keys(DSA);	
						}
					}
					else{System.out.println("invalid_fileformat");}
					
					
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
