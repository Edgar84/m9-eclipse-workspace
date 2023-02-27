package fils4;

public class PingPonc_sincMain {

	public static void main(String[] args) {
		
		PingPong_sinc p1 = new PingPong_sinc("ping");
		PingPong_sinc p2 = new PingPong_sinc("pong");
		
		p1.start();
		p2.start();

	}

}
