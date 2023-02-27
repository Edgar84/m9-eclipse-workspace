package fils4;

import java.util.concurrent.Semaphore;

public class PingPong extends Thread{
	
	private String pingPong;
	private Semaphore s1;
	private Semaphore s2;
	
	public PingPong(String s,Semaphore s1, Semaphore s2) {
		this.pingPong = s;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			try {
				s1.acquire();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i + " " + pingPong);
			s2.release();
		}
	}

}
