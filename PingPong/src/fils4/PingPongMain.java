package fils4;

import java.util.concurrent.Semaphore;

public class PingPongMain {

	public static void main(String[] args) {
		
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(0);
		PingPong p1 = new PingPong("Ping", s1, s2);
		PingPong p2 = new PingPong("Pong", s2, s1);
		
		p1.start();
		p2.start();

	}

}
