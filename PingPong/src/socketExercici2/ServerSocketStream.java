package socketExercici2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketStream {

	public static void main(String[] args) {
		
		try {
			System.out.println("Creant Socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress addr= new InetSocketAddress("192.168.19.232",7878);
			
			serverSocket.bind(addr);
			
			int count = 0;
			
			while(true) {
				count++;
				
				Socket newSocket = serverSocket.accept();
				
				System.out.println("Servidor escoltant... ja preparat");
				
				//InputStream is = newSocket.getInputStream(); // llegir
				OutputStream os = newSocket.getOutputStream(); // escriure
				
				String missatge= Integer.toString(count);;
				os.write(missatge.getBytes());
				
				System.out.println("Connexió número: " + missatge);
				
				System.out.println("Socket client tancat."); // newSocket.close() tanca la connexió del client.
				
				newSocket.close();
				
				//serverSocket.close();
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
