package fils;

public class PingPongMain {

	public static void main(String[] args) {
		
		System.out.println("Comença");
		
		PingPong ping = new PingPong("ping");
		PingPong pong = new PingPong("pong");
		
		ping.start();
		pong.start();

	}

}
