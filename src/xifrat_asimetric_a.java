import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

public class xifrat_asimetric_a {

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
			  
		/*  } catch (Exception e) {
			  e.printStackTrace();
		  }
		
		try {*/
			
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			KeyPair keypair = keygen.generateKeyPair(); 	
			
			KeyFactory keyfac = KeyFactory.getInstance("RSA");
			
			RSAPublicKeySpec publicKeySpec = keyfac.getKeySpec(keypair.getPublic(),RSAPublicKeySpec.class);
			
			BigInteger modul = publicKeySpec.getModulus();
			BigInteger exponent = publicKeySpec.getPublicExponent();
			
			RSAPublicKeySpec keyspec2 = new RSAPublicKeySpec(modul, exponent);
			
			PublicKey public_key = keyfac.generatePublic(keyspec2);
			
			inf.init(Cipher.DECRYPT_MODE, public_key);
			/*
			PublicKey publicKey = keypair.getPublic();
			PrivateKey privateKey = keypair.getPrivate();
			
			
			byte[] pubEncBytes = publicKey.getEncoded(); 
			
			String pubEncBase64 = new BASE64Encoder().encode(pubEncBytes);
			
			
			File clauPublica = new File("clauPublica.txt");
			clauPublica.createNewFile();
			FileOutputStream fos2 = new FileOutputStream(clauPublica);
			fos.write(publicKey);
			
			
			/*
			File clauPrivada = new File("clauPrivada.txt");
			if(!clauPrivada.exists()) {
				clauPrivada.createNewFile();
			}
			*/
			
			
			//Cipher rsaCipher = Cipher.getInstance("RSA"); 	
			
			/* Fitxa 31 powerPoint
			 * https://www.google.com/search?q=cifrar+archivo+con+rsa+con+clave+asimetrica+java&ei=HBlQY9jsAYqN9u8Pj5id6A8&oq=cifrar+archivo+con+rsa+java&gs_lp=ugYGCAEQARgJEgxnd3Mtd2l6LXNlcnC4AQH4AQEqAggAMggQIRjDBBigAcICChAAGEcY1gQYsAPCAg4QABjkAhjWBBiwA9gBAcICChAhGMMEGAoYoAGQBg1I-CVQ0gpYwA1wAXgByAEAkAEAmAGLAaAB5gKqAQMwLjPiAwQgTRgB4gMEIEEYAOIDBCBGGAGIBgE&sclient=gws-wiz-serp
			 * https://programmerclick.com/article/35101018848/    <--- Muy bueno
			 * http://www.jtech.ua.es/j2ee/2002-2003/modulos/seguridad/apuntes/sesion2.htm
			 * */
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		


	}

}
