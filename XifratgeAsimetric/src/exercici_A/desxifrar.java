package exercici_A;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class desxifrar {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
		
		File fitxerADesxifrar = new File("fitxerXifrat.txt");
		File pubKeyFile = new File("keys/publicKey");
		File prvKeyFile = new File("keys/privatKey");
		
		PublicKey pub = restorePublicKey(pubKeyFile);
		PrivateKey prk =  restorePrivateKey(prvKeyFile);	//<---- En aquest cas no fa falta restaurar-la
		
		decryptFile(pub, fitxerADesxifrar);

	}
	
	public static PublicKey restorePublicKey(File pubKeyFile) {
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(pubKeyFile + ".txt"));
			X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PublicKey pub = kf.generatePublic(ks);
			System.out.println("Clau Pública restaurada:\n\n" + pub);
			return pub;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static PrivateKey restorePrivateKey(File prvKeyFile) {
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(prvKeyFile + ".txt"));
			PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PrivateKey prk = kf.generatePrivate(ks);
			System.out.println("\nClau Privada restaurada:\n\n" + prk);
			return prk;
		} catch (Exception e) {
			return null;
		}

	}
	
	public static void decryptFile(PublicKey pub, File fitxerADesxifrar) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
		
		// Crear objecte Cipher xifrat RSA i inicialitzar en mode DECRYPT
		Cipher rsaCipher = Cipher.getInstance("RSA");
		rsaCipher.init(Cipher.DECRYPT_MODE, pub);
		
		// Agafem i pasem a byte[] el contingut del fitxer xifrat (a través del path, però en aquest cas està a l'arrel.)
		/*Path filePath = Path.of(fitxerADesxifrar.getAbsolutePath().toString());*/
	    byte[] bytes = Files.readAllBytes(Paths.get(fitxerADesxifrar.toString()));
	    
	    // Desxifrar
		byte[] mensajeDescifrado = rsaCipher.doFinal(bytes);
		
		// Crear un FileOutputStream i escriure-li el missatge desxifrat
		FileOutputStream fos = new FileOutputStream("fitxerDesxifrat.txt");
		fos.write(mensajeDescifrado);
		fos.close();
		
        System.out.println("\nS'ha desxifrat el contingut del fitxer correctament");
	}

}



/*
 * Fuentes:
 * https://www.jackrutorial.com/2018/07/how-to-encrypt-and-decrypt-files-in-java10.html
 * https://www.jesusninoc.com/02/05/cifrar-y-descifrar-con-rsa-desde-java-generando-clave-privada-y-clave-publica/
 * https://www.novixys.com/blog/rsa-file-encryption-decryption-java/
 * https://www.baeldung.com/java-cipher-input-output-stream
 * https://www.baeldung.com/java-cipher-class
 * 
 * Leer archivos:
 * https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
 * */
