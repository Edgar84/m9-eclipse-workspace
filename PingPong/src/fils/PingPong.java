package fils;

public class PingPong extends Thread {
	
	private String accio;
	
	public PingPong(String s) {
		accio = s;
	}
	
	public void run() {
		if (accio.equals("ping")) {
			for (int i = 1; i <= 300; i++) {
				System.out.println(i + " Ping");
			}
			
		} else if (accio.equals("pong")) {
			for (int i = 1; i <= 300; i++) {
				System.out.println(i + " Pong");
			}
		}
	}
}
