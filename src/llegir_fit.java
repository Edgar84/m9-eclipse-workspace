
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class llegir_fit {
	
	 public static void main(String[] args) {
		  try {	
	
			  File inf = new File("fitxer.txt");
	
			  FileInputStream is = new FileInputStream(inf);
	
			  FileOutputStream os = new FileOutputStream("fitxer_sortida.txt");
	
			  byte[] buffer = new byte[64];
			  int bytes_llegits = is.read(buffer);
			  while (bytes_llegits != -1) {
				  os.write(buffer);
				  bytes_llegits = is.read(buffer);
			  }
			  os.close();
			  is.close();
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	 }
}


