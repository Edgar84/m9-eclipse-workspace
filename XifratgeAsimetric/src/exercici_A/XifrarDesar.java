package exercici_A;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class XifrarDesar {

	public static void main(String[] args) {
		try {
			File dir = new File("keys");
			if(!dir.exists()) { dir.mkdir();}
			
			//Crear contigut per a xifrar
			File fitxerAXifrar = new File("fitxerAxifrar.txt");
			if(!fitxerAXifrar.exists()) { fitxerAXifrar.createNewFile();}
			
			String content = "Això es un missatge per a xifrar";
			byte[] contentInBytes = content.getBytes();
			
			FileOutputStream fOut = new FileOutputStream(fitxerAXifrar);
			fOut.write(contentInBytes);
			fOut.close();
			
			// Crear el parell de claus RSA, pública i privada
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048);
			KeyPair kp = kpg.generateKeyPair();
			
			PublicKey pub = kp.getPublic();
			PrivateKey pr = kp.getPrivate();
			
			System.out.println("Clau Pública: " + pub);
			System.out.println("Clau Privada: " + pr);
			
			// Guardar claus i encriptar fitxer
			savePublicKey(kp);
			savePrivateKey(kp);
			encryptFile(fitxerAXifrar,pr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void savePublicKey(KeyPair kp) throws IOException{
		
		File pubKeyFile = new File("keys/publicKey.txt");
		if(!pubKeyFile.exists()) { pubKeyFile.createNewFile();}
		FileOutputStream fOut = new FileOutputStream(pubKeyFile);
		fOut.write(kp.getPublic().getEncoded());
		fOut.close();
		
	}
	public static void savePrivateKey(KeyPair kp) throws IOException{
		
		File prvKeyFile = new File("keys/privatKey.txt");
		if(!prvKeyFile.exists()) { prvKeyFile.createNewFile();}
		FileOutputStream fOut = new FileOutputStream(prvKeyFile);
		fOut.write(kp.getPrivate().getEncoded());
		fOut.close();
		
	}
	
	public static void encryptFile(File fitxerAXifrar, PrivateKey pr) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
		
		// Crear objecte Cipher xifrat RSA i inicialitzar en mode ENCRYPT
		Cipher rsaCipher = Cipher.getInstance("RSA");
		rsaCipher.init(Cipher.ENCRYPT_MODE, pr);
		
		// Agafem i pasem a byte[] el contingut del fitxer xifrat (a través del path, però en aquest cas està a l'arrel.)
		/*Path filePath = Path.of(fitxerADesxifrar.getAbsolutePath().toString());*/
	    byte[] inputBytes = Files.readAllBytes(Paths.get(fitxerAXifrar.toString()));
	    
    /*  Una altre manera d'extreure el contingut en byte[]:
 	 *	FileInputStream fis = new FileInputStream(fitxerAXifrar);
 	 *	byte[] inputBytes = new byte[(int) fitxerAXifrar.length()];
	 */
	    
		// Xifrar.
		byte[] mXif = rsaCipher.doFinal(inputBytes); 
		
		// Crear un FileOutputStream i escriure-li el missatge xifrat
		FileOutputStream fos = new FileOutputStream("fitxerXifrat.txt");
		fos.write(mXif);
		fos.close();
		
		System.out.println("\nS'ha xifrat el contingut del fitxer correctament");
		
	}

}
