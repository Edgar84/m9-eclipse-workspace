package filsPeluquer;

import java.util.concurrent.Semaphore;

public class Client extends Thread {

	
	public static void main(String[] args) throws InterruptedException {
		
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(1);
		
		Perruqueria c1 = new Perruqueria("Client1", 30, s1, s2);
		Perruqueria c2 = new Perruqueria("Client2", 40, s1, s2);
		Perruqueria c3 = new Perruqueria("Client3", 20, s1, s2);
		Perruqueria c4 = new Perruqueria("Client4", 10, s1, s2);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		
		c1.join();
		c2.join();
		c3.join();
		c4.join();
		
		System.out.println("Ja no hi ha mes clients");
		
	}
	
	
}
