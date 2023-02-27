package fils2;

public class CompteEnrereDos extends Thread {

	private int num;
	
	public CompteEnrereDos(int a) {
		num = a;
	}
	
	public void run() {
		for (int i = 50; i >= 0; i--) {
			System.out.println("Fill" + num + " compte enrrere: " + i);
		}
	}

}
