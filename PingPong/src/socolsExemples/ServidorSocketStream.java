package socolsExemples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocketStream {
	public static void main(String[] args){
		try{
			System.out.println("Creant Socket servidor");
			// crear socket de servidor
			ServerSocket serverSocket = new ServerSocket();
			// establir una ip i un port (sense port no funciona)
			InetSocketAddress addr= new InetSocketAddress("192.168.19.232",7878);
			// asigar-li al socket l'adreça anterior
			serverSocket.bind(addr);
			
			// Deixem el socket en epera de connexió del client
			Socket newSocket = serverSocket.accept();
			

			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();
			
			byte[] missatge = new byte[50];
			// Llegim el missatge que ens passa el client
			is.read(missatge);
			
			
			System.out.println("Missatge rebut: "+ new String(missatge));
			// Tanquem el socket client
			newSocket.close();
			// Tanquem el socket servidor
			serverSocket.close();
			
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}	
}
