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
