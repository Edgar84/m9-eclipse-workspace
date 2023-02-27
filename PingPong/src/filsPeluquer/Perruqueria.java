package filsPeluquer;

import java.util.concurrent.Semaphore;

public class Perruqueria extends Thread {

	private String nom;
	private int dificultat;
	private Semaphore sr;
	private Semaphore st;
	
	public Perruqueria(String n, int d, Semaphore s, Semaphore t) {
		this.nom = n;
		this.dificultat = d;
		this.sr = s;
		this.st = t;
	}
	
	
	public void run() {
		try {
			sr.acquire();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i< 10; i++) {
			System.out.println(nom + ".R." + i );
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		sr.release();

		try {
			st.acquire();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i< dificultat; i++) {
			System.out.println(nom + ".T." + i );
		}
		
		st.release();
	}

}

