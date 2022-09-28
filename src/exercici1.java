import java.util.Scanner;
import javax.crypto.*;

public class exercici1 {

	public static void main(String[] args) {
		
		String pass = "";
		String tipus = "";
		try (Scanner entrada = new Scanner(System.in)) {
			while(pass.equals("")) {
				System.out.println("Escriu la teva contrasenta");
				pass = entrada.nextLine();
			}
			while(tipus.equals("")) {
				System.out.println("Introdueix el tipus de xifrat");
				System.out.println("1- DES");
				System.out.println("2- AES");
				int opcioMenu = entrada.nextInt();
			    switch(opcioMenu){
			        case 1:
			            tipus = "DES";
			        case 2:
			            tipus = "AES";
			            break;
			        default:
			            System.out.println("Opció incorrecta");
			            tipus = "";
			            break;
			    }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		generateCipher(pass,tipus);
	}
	//Encriptar una contraseña segons el tiupus de xifrat
	public static void generateCipher(String pass, String type) {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance(type);
			SecretKey key = keygen.generateKey();
			Cipher dCipher = Cipher.getInstance(type);
			dCipher.init(Cipher.ENCRYPT_MODE, key);
			String mx = new String(dCipher.doFinal(pass.getBytes()));
			System.out.println("Contrasenya xifrada: \n" + mx);
		}catch(Exception e) {
			e.printStackTrace();
		}
	};
}


