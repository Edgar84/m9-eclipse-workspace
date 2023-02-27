package socketExercici3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketA {
	
	public static void main(String[] args) {
	    
		try{
			//Crear/agafar arxiu
			File file = new File("missatge.txt");
		    FileInputStream fis = new FileInputStream(file);
			
			System.out.println("Programa A servidor");
			
			ServerSocket serverSocket = new ServerSocket();
			//InetSocketAddress addr= new InetSocketAddress("192.168.16.41",7878);
			InetSocketAddress addr= new InetSocketAddress("localhost",7878);
			serverSocket.bind(addr);
			
			Socket newSocket = serverSocket.accept();		
			
			//OutputStream os = newSocket.getOutputStream(); 	// escriure
			//InputStream is = newSocket.getInputStream();		// llegir
			DataOutputStream os = new DataOutputStream(newSocket.getOutputStream());	
			
			// Guardar els bytes del nom arxiu
			String nomArxiu = file.getName();
			byte[] nomArxiuBytes = nomArxiu.getBytes();
			
			//Guardar els bytes del contingut
			byte[] contingutArxiuBytes = new byte[(int)file.length()];
			fis.read(contingutArxiuBytes);
			
			// Escriure  al DataOutputStream el num de bytes del nom i el nom, el num de bytes del contingut i el contingut
			os.writeInt(nomArxiuBytes.length);
			os.write(nomArxiuBytes);
			
			os.writeInt(contingutArxiuBytes.length);
			os.write(contingutArxiuBytes);
					
			//tanquem tot
			fis.close();
			newSocket.close();
			serverSocket.close();
			
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
