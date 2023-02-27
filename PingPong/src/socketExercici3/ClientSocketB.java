package socketExercici3;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocketB {

	public static void main(String[] args) {
		
		try{
			System.out.println("Programa B client");
			
			//Socket cs = new Socket("192.168.16.41",7878);
			Socket cs = new Socket("localhost",7878);
			System.out.println("Establint la connexió");
			
			//InputStream is = cs.getInputStream(); // llegir
			//OutputStream os = cs.getOutputStream(); // escriure
			
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			
			//llegir longitud dels bytes del nom de l'arxiu
			int nomArxiuLength = dis.readInt();
			String nomArxiu = "";
			
			if(nomArxiuLength > 0) {
				
				//Crear array de bytes amb la longitud exacta
				byte[] nomArxiuBytes = new byte[nomArxiuLength];
				dis.readFully(nomArxiuBytes);
				nomArxiu = new String(nomArxiuBytes);
				
				//llegir longitud dels bytes del contingut de l'arxiu
				int contingutArxiuLength = dis.readInt();
				String contingutArxiu = "";
				
				if(contingutArxiuLength > 0) {
					//Crear array de bytes amb la longitud exacta del contingut
					byte[] contingutArxiuBytes = new byte[contingutArxiuLength];
					dis.readFully(contingutArxiuBytes);
					contingutArxiu = new String(contingutArxiuBytes);
					
					System.out.print("\nLlegint arxiu:\n" + nomArxiu + "\n\n" + contingutArxiu);
				}else {
					System.out.println("\nNo hi ha dades dins l'arxiu");
				}
				
			}else {
				System.out.println("\nNo he pogut llegir cap arxiu");
			}
			
			//Tancar
			cs.close();
			
		} catch(IOException e){
			e.printStackTrace();
		}

	}

}
