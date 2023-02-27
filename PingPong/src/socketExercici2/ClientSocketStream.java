package socketExercici2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocketStream {

	public static void main(String[] args) {
		try{
			System.out.println("Creant Socket client");
			
			Socket cs = new Socket("192.168.19.232",7878);
			//Socket cs = new Socket();

			System.out.println("Establint la connexió");
			
			//InetSocketAddress addr= new InetSocketAddress("localhost",7878);
			//cs.connect(addr);
			
			InputStream is=cs.getInputStream(); 	// llegir
			//OutputStream os=cs.getOutputStream(); // escriure
			
			byte[] missatge = new byte[50];
			is.read(missatge);
			
			String con="Connexió número:" + missatge;
			
			System.out.println("Missatge rebut" + con);
			
			
			cs.close();
			
		} catch(IOException e){
			e.printStackTrace();
		}

	}

}
