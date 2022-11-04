
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class llegir_fit2 {
	
	 public static void main(String[] args) {
		  try {	
	
			  File inf = new File("fitxer.txt");
	
			  FileInputStream is = new FileInputStream(inf);
	
			  FileOutputStream os = new FileOutputStream("fitxer_sortida.txt");
	
			  byte[] buffer = new byte[(int) inf.length()];

			  is.read(buffer);
			  os.write(buffer);
			  
			  os.close();
			  is.close();
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	 }
}


