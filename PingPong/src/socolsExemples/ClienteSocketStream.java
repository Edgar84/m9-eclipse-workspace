package socolsExemples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketStream {

	public static void main(String[] args){
		try{
			System.out.println("Creant Socket client");
			
			// Creem el socker client amb una ip i un port
			Socket cs = new Socket("192.168.19.232",7878);
			// O creem el socket, una adreça i asignem l'adreça al socket
			//Socket cs = new Socket();
			//InetSocketAddress addr= new InetSocketAddress("localhost",7878);
			//cs.connect(addr);
			
			System.out.println("Establint la connexió");
			
			//InputStream is=cs.getInputStream();
			OutputStream os=cs.getOutputStream();
			
			//Creem el missatge a enviar i escrivim amb l'OuputStream
			String missatge="Hola Missatge: BEEP";
			os.write(missatge.getBytes());
			
			//Tanquem el socket
			cs.close();
			
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
